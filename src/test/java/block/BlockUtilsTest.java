package block;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static block.TestUtils.alphanumericPattern;
import static block.TestUtils.hexHashPattern;

public class BlockUtilsTest {

    @Test
    public void randomAlphanumericString() {
        for (int i = 0; i <= 256; i++) {
            String testString = BlockUtils.randomAlphanumericString(i);
            System.out.println(testString);
            Assert.assertEquals(i, testString.length());
            Assert.assertTrue(alphanumericPattern.matcher(testString).matches());
        }
    }

    @Test
    public void sha256HexHash() {
        Random random = new Random();
        for (int i = 0; i <= 256; i++) {
            byte[] bytes = new byte[i];
            random.nextBytes(bytes);
            String dataToHash = new String(bytes);
            System.out.println(dataToHash);

            String hash = BlockUtils.sha256HexHash(dataToHash);
            System.out.println(hash);
            Assert.assertTrue(hexHashPattern.matcher(hash).matches());
        }
    }

    @Test
    public void repeat() {
        Assert.assertEquals("0", BlockUtils.repeat('0', 1));
        Assert.assertEquals("11", BlockUtils.repeat('1', 2));
        Assert.assertEquals("---", BlockUtils.repeat('-', 3));
        Assert.assertEquals("aaaa", BlockUtils.repeat('a', 4));
        Assert.assertEquals("BBBBB", BlockUtils.repeat('B', 5));
        Assert.assertEquals("      ", BlockUtils.repeat(' ', 6));
        Assert.assertEquals("", BlockUtils.repeat('X', 0));
    }
}