package javaUtilConcurrentPackage.priorityBlockingQueue;

import javaUtilConcurrentPackage.commonPart.Consumer;
import javaUtilConcurrentPackage.commonPart.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Example using PriorityBlockingQueue.
 * Unbounded concurrent queue.
 * Elements in natural ordering or by Comparator.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 20:31
 */
public class PriorityBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(5000);

    }
}
