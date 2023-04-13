package p2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Server implements Runnable {

    private final ServerSocket serverSocket;
    private boolean isRunning;

    private Set<ClientConnection> connections;
    private ExecutorService pool;

    private Consumer<String> requestConsumer;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onRequest(Consumer<String> consumer) {
        this.requestConsumer = consumer;
    }

    @Override
    public void run() {
        try {
            isRunning = true;
            connections = Collections.synchronizedSet(new HashSet<>());
            pool = Executors.newCachedThreadPool();
            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                ClientConnection clientConnection = new ClientConnection(clientSocket);
                connections.add(clientConnection);
                pool.execute(clientConnection);
            }
        } catch (IOException e) {
            // ignore
        } finally {
            shutdown();
        }
    }

    public void shutdown() {
        try {
            isRunning = false;
            serverSocket.close();
            connections.forEach(ClientConnection::close);
            pool.shutdown();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private class ClientConnection extends Thread {

        private final Socket clientSocket;
        private BufferedReader in;

        public ClientConnection(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String request;
                while ((request = in.readLine()) != null) {
                    if (requestConsumer != null) requestConsumer.accept(request);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                close();
            }
        }

        public void close() {
            try {
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
