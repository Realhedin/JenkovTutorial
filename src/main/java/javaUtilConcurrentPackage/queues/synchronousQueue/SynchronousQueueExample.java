package javaUtilConcurrentPackage.queues.synchronousQueue;

import javaUtilConcurrentPackage.queues.commonPart.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Simple example of using with SynchronousQueue implementation.
 * Can only contain a single element internally!
 * Producer is blocked if queue.size() > 1.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 20:39
 */
public class SynchronousQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(3000);
    }
}
