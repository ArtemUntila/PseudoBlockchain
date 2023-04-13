package block;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class BlockGenerator {

    private final Supplier<String> dataSupplier;
    private final Predicate<String> hashPredicate;

    public BlockGenerator(Supplier<String> dataSupplier, Predicate<String> hashPredicate) {
        this.dataSupplier = dataSupplier;
        this.hashPredicate = hashPredicate;
    }

    public Block mine(Block block) {
        while (!hashPredicate.test(block.getHash())) {
            block.incrementNonce();
            block.calculateHash();
        }
        return block;
    }

    public Block generate(int id, String prevHash) {
        Block block = new Block(id, prevHash, dataSupplier.get());
        return mine(block);
    }
}
