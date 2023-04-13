import block.Block;
import block.BlockGenerator;
import block.BlockUtils;
import com.google.gson.Gson;
import p2p.Peer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class Node {

    public static final int DATA_LENGTH = 256;
    public static final String SUFFIX = BlockUtils.repeat('0', 4);

    private final Peer peer;
    private boolean isRunning;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private Future<Block> future;

    private final LinkedList<Block> blockchain = new LinkedList<>();
    private final AtomicReference<String> received = new AtomicReference<>();

    private final BlockGenerator blockGenerator;
    private final Gson gson = new Gson();

    public Node(int port, int... ports) {
        peer = new Peer(port, ports);
        blockGenerator = new BlockGenerator(
                () -> BlockUtils.randomAlphanumericString(DATA_LENGTH),
                s -> s.endsWith(SUFFIX)
        );
    }

    public void start(boolean genesis) {
        isRunning = true;
        peer.startServer();

        peer.onRequest(s -> {
            received.set(s);
            if (future != null) future.cancel(true);
        });

        if (genesis) {
            System.out.println("Generating genesis...");
            Block genesisBlock = blockGenerator.generate(0, BlockUtils.GENESIS_PREV_HASH);
            addAndBroadcast(genesisBlock);
        } else {
            System.out.println("Waiting for genesis...");
            while (received.get() == null) {
                // Wait for the genesis block to be received
            }
        }

        while (isRunning) {
            try {
                future = executor.submit(() -> blockGenerator.generate(
                        blockchain.size(),
                        blockchain.getLast().getHash()
                ));
                Block block = future.get();
                addAndBroadcast(block);
            } catch (Exception e) {
                validateAndAdd(received.get());
            }
        }
    }

    private void validateAndAdd(String json) {
        Block block = gson.fromJson(json, Block.class);
        if (validateBlock(block)) {
            blockchain.add(block);
            System.out.println("SLAVE : " + json);
        }
    }

    private void addAndBroadcast(Block block) {
        blockchain.add(block);
        String json = gson.toJson(block);
        peer.broadcast(json);
        System.out.println("MASTER: " + json);
    }


    public boolean validateBlock(Block block) {
        String prevHash = blockchain.isEmpty() ? BlockUtils.GENESIS_PREV_HASH : blockchain.getLast().getHash();
        return (block.getHash().endsWith(SUFFIX)) &&
                (block.getId() == blockchain.size()) &&
                (Objects.equals(block.getPrevHash(), prevHash));
    }

    public void shutdown() {
        isRunning = false;
        peer.shutdown();
        executor.shutdown();
    }
}
