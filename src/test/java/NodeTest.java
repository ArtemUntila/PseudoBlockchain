import block.Block;
import block.BlockGenerator;
import block.BlockUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NodeTest {

    @Test  // Test if nodes start, exchange and shutdown OK
    public void startAndShutdown() throws InterruptedException, ExecutionException {
        Node node1 = new Node(9020, 9021);
        Node node2 = new Node(9021, 9020);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> future2 = executor.submit(() -> node2.start(false));
        Future<?> future1 = executor.submit(() -> node1.start(true));

        Thread.sleep(2000);

        node2.shutdown();
        node1.shutdown();

        // Wait if node has started generating new block
        // It is OK if there are 2 MASTER with the same block id at the end of the output
        future2.get();
        future1.get();

        Assert.assertTrue(future2.isDone());
        Assert.assertTrue(future1.isDone());
    }

    @Test
    public void validate() {
        Node nodeDummy = new Node(0);
        Block genesis = new Block(0, BlockUtils.GENESIS_PREV_HASH, "data");
        System.out.println("Init hash: " + genesis.getHash());
        Assert.assertFalse(nodeDummy.validateBlock(genesis));

        BlockGenerator generatorDummy = new BlockGenerator(null, s -> s.endsWith("0000"));
        generatorDummy.mine(genesis);
        System.out.println("Mine hash: " + genesis.getHash());
        Assert.assertTrue(nodeDummy.validateBlock(genesis));
    }
}
