package block;


import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class BlockGeneratorTest {

    public static final Predicate<String> hashPredicate = s -> s.endsWith("0000");

    private final BlockGenerator blockGenerator = new BlockGenerator(() -> "data", hashPredicate);

    @Test
    public void mine() {
        Block block = new Block(0, "prevHash", "data");
        Block minedBlock = blockGenerator.mine(block);
        Assert.assertEquals(block, minedBlock);
        Assert.assertTrue(hashPredicate.test(block.getHash()));
    }

    @Test
    public void generate() {
        int id = 1;
        String prevHash = "prevHash";
        Block block = blockGenerator.generate(id, prevHash);
        Assert.assertEquals(id, block.getId());
        Assert.assertEquals(prevHash, block.getPrevHash());
        Assert.assertTrue(hashPredicate.test(block.getHash()));
    }
}