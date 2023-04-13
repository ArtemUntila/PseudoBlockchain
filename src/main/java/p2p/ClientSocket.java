package p2p;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientSocket {

    private final Socket socket;
    private final PrintWriter out;

    public ClientSocket(String host, int port) throws IOException {
        this(host, port, 10);
    }

    public ClientSocket(String host, int port, int timeout) throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), timeout);
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void send(String message) {
        out.println(message);
    }

    public void close() throws IOException {
        out.close();
        socket.close();
    }
}
