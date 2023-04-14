import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NodeCommandTest {

    @Test  // Test if arguments are parsed correctly: nodes start, exchange and don't shut down prematurely
    public void mainTest() throws InterruptedException {
        String[] args0 = {"-p", "8080", "-n", "8081", "-n", "8082", "-g"};
        String[] args1 = {"-p", "8081", "-n", "8080", "-n", "8082"};
        String[] args2 = {"-p", "8082", "-n", "8080", "-n", "8081"};

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> NodeCommand.main(args2));
        executor.execute(() -> NodeCommand.main(args1));
        executor.execute(() -> NodeCommand.main(args0));

        Assert.assertFalse(executor.awaitTermination(3, TimeUnit.SECONDS));
    }
}
