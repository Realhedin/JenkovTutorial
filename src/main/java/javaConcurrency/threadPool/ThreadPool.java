package javaConcurrency.threadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Public interface to the thread pool.
 *
 * @author dkorolev
 *         Date: 14.10.15
 *         Time: 20:27
 */
public class ThreadPool {

    private SimpleBlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;


    //Constructor to initialize taskQueue and set create threads and start them
    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new SimpleBlockingQueue(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            threads.add(new PoolThread(taskQueue));
        }

        for (PoolThread thread : threads) {
            thread.start();
        }
    }

    //add task to our queue
    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.taskQueue.enqueue(task);
    }


    //global stop for our threads
    public synchronized void stop() {
        this.isStopped = true;
        for (PoolThread thread : threads) {
            thread.stop();
        }
    }
}
