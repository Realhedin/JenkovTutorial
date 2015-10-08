package javaConcurrency.javaSynchronizedBlocks;

/**
 * @author dkorolev
 *         Date: 08.10.15
 *         Time: 19:56
 */
public class Counter {

    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
        System.out.println("Thread #"+Thread.currentThread().getName()+ " | i:"+value+" | count:"+this.count);
    }
}
