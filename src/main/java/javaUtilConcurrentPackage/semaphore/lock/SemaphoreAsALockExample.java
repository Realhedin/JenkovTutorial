package javaUtilConcurrentPackage.semaphore.lock;

import java.util.concurrent.Semaphore;

/**
 * Example of using Semaphore as a lock (guard a critical section).
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 20:51
 */
public class SemaphoreAsALockExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        new Thread(new SemaphoreRunnable(semaphore)).start();
        new Thread(new SemaphoreRunnable(semaphore)).start();
        new Thread(new SemaphoreRunnable(semaphore)).start();
        new Thread(new SemaphoreRunnable(semaphore)).start();
        new Thread(new SemaphoreRunnable(semaphore)).start();

    }
}
