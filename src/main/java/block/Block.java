package block;

public class Block {

    private final int id;
    private final String prevHash;
    private String hash;
    private final String data;
    private int nonce;

    public Block(int id, String prevHash, String data) {
        this.id = id;
        this.prevHash = prevHash;
        this.data = data;
        calculateHash();
    }

    public void calculateHash() {
        String dataToHash = String.format("%d%s%s%d", id, prevHash, data, nonce);
        // TODO: Calculate and set hash with SHA-256
    }

    public void incrementNonce() {
        nonce++;
    }

    public int getId() {
        return id;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public String getHash() {
        return hash;
    }
}
