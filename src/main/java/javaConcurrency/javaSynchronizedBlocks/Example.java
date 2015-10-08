package javaConcurrency.javaSynchronizedBlocks;

/**
 * One instance that is shared object between 2 threads.
 * they block each other on add() method.
 * result value of count is 90.
 *
 * @author dkorolev
 *         Date: 08.10.15
 *         Time: 19:59
 */
public class Example {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
    }
}
