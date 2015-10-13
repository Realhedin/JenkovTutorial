package javaConcurrency.blockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of BlockingQueue by hand.
 *
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 20:49
 */
public class SimpleBlockingQueue {

    private List queue = new LinkedList();
    private int limit = 0;

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object item) {
        while (this.queue.size() == this.limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Object dequeue() {
        while (this.queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }


    public int getQueueSize() {
        return queue.size();
    }
}
