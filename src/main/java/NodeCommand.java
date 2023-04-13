import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "node", mixinStandardHelpOptions = true, version = "1.0")
public class NodeCommand implements Runnable {

    @Option(names = {"-p", "--port"}, required = true, description = "Node port.")
    int port;

    @Option(names = {"-n", "--node"}, description = "Other node port.")
    int[] nodes;

    @Option(names = {"-g", "--genesis"}, description = "Generate genesis block.")
    boolean genesis;

    @Override
    public void run() {
        Node node = new Node(port, nodes);
        try {
            node.start(genesis);
        } catch (Exception e) {
            node.shutdown();
        }
    }

    public static void main(String[] args) {
        int status = new CommandLine(new NodeCommand()).execute(args);
        System.exit(status);
    }
}
