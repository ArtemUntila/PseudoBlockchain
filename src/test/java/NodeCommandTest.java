import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NodeCommandTest {

    @Test  // Test if arguments are parsed correctly: nodes start, exchange and don't shut down prematurely
    public void mainTest() throws InterruptedException {
        String[] args0 = {"-p", "9020", "-n", "9021", "-n", "9022", "-g"};
        String[] args1 = {"-p", "9021", "-n", "9020", "-n", "9022"};
        String[] args2 = {"-p", "9022", "-n", "9020", "-n", "9021"};

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> NodeCommand.main(args2));
        executor.execute(() -> NodeCommand.main(args1));
        executor.execute(() -> NodeCommand.main(args0));

        Assert.assertFalse(executor.awaitTermination(3, TimeUnit.SECONDS));
    }
}
