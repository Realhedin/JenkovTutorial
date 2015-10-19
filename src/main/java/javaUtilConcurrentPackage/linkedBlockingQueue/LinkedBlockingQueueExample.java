package javaUtilConcurrentPackage.linkedBlockingQueue;

import javaUtilConcurrentPackage.commonPart.Consumer;
import javaUtilConcurrentPackage.commonPart.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Simple example of using with LinkedBlockingQueue implementation.
 * Stores elements as linked list.
 * optional bounded (if no bound, Integer.MAX_VALUE).
 * FIFO.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 20:19
 */
public class LinkedBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(5000);
    }
}
