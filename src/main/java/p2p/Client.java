package p2p;

import java.io.IOException;

public class Client {

    private final String host;
    private final int port;

    public Client(int port) {
        this("localhost", port);
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public boolean send(String message) {
        try {
            ClientSocket clientSocket = new ClientSocket(host, port);
            clientSocket.send(message);
            clientSocket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
