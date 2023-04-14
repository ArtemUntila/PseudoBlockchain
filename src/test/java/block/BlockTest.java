package block;


import org.junit.Assert;
import org.junit.Test;

import static block.TestUtils.hexHashPattern;

public class BlockTest {

    @Test
    public void initHash() {
        Block block = new Block(0, "prevHash", "data");
        Assert.assertTrue(hexHashPattern.matcher(block.getHash()).matches());
    }
}