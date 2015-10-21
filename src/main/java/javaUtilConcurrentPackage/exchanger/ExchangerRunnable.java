package javaUtilConcurrentPackage.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Exchanges generic object with another thread.
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 20:21
 */
public class ExchangerRunnable<T> implements Runnable {

    Exchanger<T> exchanger = null;
    T object = null;


    public ExchangerRunnable(Exchanger<T> exchanger, T object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    @Override
    public void run() {

        try {
            Object previous = this.object;
            System.out.println(Thread.currentThread().getName() + " has object: "+this.object);
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName()
                    + " exchanged " + previous + " for " + this.object);
            System.out.println("Now,"+Thread.currentThread().getName() + " has object: "+this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
