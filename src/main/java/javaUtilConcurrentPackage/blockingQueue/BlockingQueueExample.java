package javaUtilConcurrentPackage.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Simple example of using with ArrayBlockingQueue implementation.
 * Stores element as array.
 * Bounded.
 * FIFO.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 19:31
 */
public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1024);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(5000);
    }
}
