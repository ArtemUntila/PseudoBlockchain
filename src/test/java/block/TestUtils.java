package block;

import java.util.regex.Pattern;

public final class TestUtils {

    private TestUtils() {
    }

    public static final Pattern alphanumericPattern = Pattern.compile("[A-Za-z0-9]*");

    public static final Pattern hexHashPattern = Pattern.compile("[0-9a-f]{64}");
}
