package javaUtilConcurrentPackage.commonPart;

import java.util.concurrent.BlockingQueue;

/**
 * Consumer class that reads messages from a queue.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 19:34
 */
public class Consumer implements Runnable {

    protected BlockingQueue<String> queue = null;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }



}
