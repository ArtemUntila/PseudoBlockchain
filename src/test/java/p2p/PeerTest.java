package p2p;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class PeerTest {

    @Test
    public void p2pCommunication() throws InterruptedException {
        Peer peer1 = new Peer(9020, 9021);
        Peer peer2 = new Peer(9021, 9020);

        String peer1Message = "Peer 1";
        String peer2Message = "Peer 2";

        AtomicReference<String> peer1Received = new AtomicReference<>();
        AtomicReference<String> peer2Received = new AtomicReference<>();

        CountDownLatch latch = new CountDownLatch(2);

        peer1.onRequest(s -> {
            peer1Received.set(s);
            latch.countDown();
        });
        peer2.onRequest(s -> {
            peer2Received.set(s);
            latch.countDown();
        });

        peer1.startServer();
        peer2.startServer();

        peer1.broadcast(peer1Message);
        peer2.broadcast(peer2Message);

        // Wait for AtomicReferences to be set
        latch.await();

        peer1.shutdown();
        peer2.shutdown();

        String peer1ReceivedMessage = peer1Received.get();
        String peer2ReceivedMessage = peer2Received.get();

        System.out.printf("peer1: %s - %s\n", peer1Message, peer1ReceivedMessage);
        System.out.printf("peer2: %s - %s\n", peer2Message, peer2ReceivedMessage);

        Assert.assertEquals(peer1Message, peer2ReceivedMessage);
        Assert.assertEquals(peer2Message, peer1ReceivedMessage);
    }
}
