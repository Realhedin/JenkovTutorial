package javaConcurrency.threadPool;

/**
 * Example of working threadPool by hand.
 * ThreadPool is created with number of threads
 * and max number of tasks.
 * Threads are waiting in a thread pool for tasks.
 * As soon as execute() method takes place, it adds
 * new task into the queue and one of the idle threads
 * starts to execute this task until limit is reached.
 *
 * @author dkorolev
 *         Date: 14.10.15
 *         Time: 20:52
 */
public class ExampleThreadPool {

    public static void main(String[] args) {
        //create Thread pool
        ThreadPool threadPool = new ThreadPool(2, 3);

        //run 2 task 10 times
            for (int i = 0; i < 10; i++) {
            try {
                threadPool.execute(() -> {/*some task*/});
                threadPool.execute(() -> {/*some task*/});
            } catch (Exception e) {
                //some logic
            }

        }

        //just sleep to let other processes finish.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //some logic
        }

        //stop all threads in ThreadPool
        threadPool.stop();

    }
}
