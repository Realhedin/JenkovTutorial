package javaUtilConcurrentPackage.semaphore.lock;

import java.util.concurrent.Semaphore;

/**
 * Acquires lock and then releases it.
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 20:47
 */
public class SemaphoreRunnable implements Runnable {

    Semaphore semaphore = null;

    public SemaphoreRunnable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " took the permit"
                    + " | permits left:" + semaphore.availablePermits());
            Thread.sleep((long) (Math.random() * 1000L));
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " released the permit"
                    + " | permits left:" + semaphore.availablePermits());
        }

    }
}
