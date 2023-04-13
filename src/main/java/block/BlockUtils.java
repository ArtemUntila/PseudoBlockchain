package block;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public final class BlockUtils {

    public static final String GENESIS_PREV_HASH = repeat('0', 64);

    private static final Random random = new Random();
    private static final MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private BlockUtils() {
    }

    public static String randomAlphanumericString(int length) {
        return random.ints(48, 123)  // 0, z
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))  // only alphanumeric symbols
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public synchronized static String sha256HexHash(String data) {
        byte[] bytes = messageDigest.digest(data.getBytes(StandardCharsets.UTF_8));
        return DatatypeConverter.printHexBinary(bytes).toLowerCase();
    }

    public static String repeat(char c, int length) {
        return new String(new char[length]).replace('\0', c);
    }
}
