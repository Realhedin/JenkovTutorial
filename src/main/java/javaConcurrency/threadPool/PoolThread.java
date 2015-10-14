package javaConcurrency.threadPool;

/**
 * Implementation of the threads that execute the tasks.
 *
 * @author dkorolev
 *         Date: 14.10.15
 *         Time: 20:28
 */
public class PoolThread extends Thread{

    private SimpleBlockingQueue taskQueue = null;
    private boolean isStopped = false;


    public PoolThread(SimpleBlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }


    @Override
    public void run() {
        while (!isStopped()) {
            try {
            Runnable runnable = (Runnable)taskQueue.dequeue();
            runnable.run();
            } catch (Exception e) {
                //log it
                System.err.println(e.getMessage());
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
