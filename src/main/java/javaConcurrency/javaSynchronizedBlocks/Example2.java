package javaConcurrency.javaSynchronizedBlocks;

/**
 * Two different instances.
 * 2 Threads don't block each other.
 * count value is 45 for both of them.
 *
 * @author dkorolev
 *         Date: 08.10.15
 *         Time: 20:17
 */
public class Example2 {

    public static void main(String[] args){
        Counter counterA = new Counter();
        Counter counterB = new Counter();
        Thread  threadA = new CounterThread(counterA);
        Thread  threadB = new CounterThread(counterB);

        threadA.start();
        threadB.start();
    }
}
