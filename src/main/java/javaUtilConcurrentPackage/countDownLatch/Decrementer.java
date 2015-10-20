package javaUtilConcurrentPackage.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Decrements latch by 1 per second.
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 20:41
 */
public class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Count: "+this.latch.getCount());
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("Count: "+this.latch.getCount());
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("Count: "+this.latch.getCount());
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("Count: "+this.latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
