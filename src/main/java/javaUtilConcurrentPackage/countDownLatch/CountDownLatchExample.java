package javaUtilConcurrentPackage.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Example of CountDownLatch.
 * It is a concurrency mechanism to allow one or more threads to wait
 * for a given set of operations to complete.
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 20:41
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);


        new Thread(new Waiter(countDownLatch)).start();
        new Thread(new Waiter(countDownLatch)).start();
        new Thread(new Decrementer(countDownLatch)).start();

        Thread.sleep(5000);


    }
}
