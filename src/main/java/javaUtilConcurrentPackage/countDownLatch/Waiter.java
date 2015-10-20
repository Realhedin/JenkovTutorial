package javaUtilConcurrentPackage.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Implementation of a waiter who
 * waits until CountDownLatch's count becomes zero.
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 20:38
 */
public class Waiter implements Runnable {

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiter is blocked");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.out.println("Waiter is released!");
    }
}
