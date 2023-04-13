package p2p;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Peer {

    private final Server server;
    private final Set<Client> clients;
    private boolean serverIsRunning;

    public Peer(int port, int... ports) {
        server = new Server(port);
        clients = new HashSet<>();
        for (int p : ports) {
            addClient(p);
        }
    }

    public boolean addClient(int port) {
        Client client = new Client(port);
        return clients.add(client);
    }

    public void onRequest(Consumer<String> consumer) {
        server.onRequest(consumer);
    }

    public void startServer() {
        if (!serverIsRunning) {
            new Thread(server).start();
            serverIsRunning = true;
        }
    }

    public void broadcast(String message) {
        clients.forEach(client -> client.send(message));
    }

    public void shutdown() {
        server.shutdown();
        serverIsRunning = false;
    }
}
