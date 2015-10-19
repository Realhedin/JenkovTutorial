package javaUtilConcurrentPackage.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Producer class that puts messages in a queue.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 19:31
 */
public class Producer implements Runnable{

    protected BlockingQueue<String> queue = null;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
