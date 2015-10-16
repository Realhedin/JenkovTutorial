package javaConcurrency.nonBlockingAlgorithms.volatileOneWriterManyReaders;

import javaConcurrency.nonBlockingAlgorithms.SimpleCounter;

/**
 * Thread that write to volatile variable.
 * Each object of this class should use
 * only one instance of SingleWriterCounter object.
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 14:47
 */
public class NonblockingThreadWriter extends Thread {

    private SimpleCounter counter;


    public NonblockingThreadWriter(SimpleCounter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        while (true) {
            counter.inc();
            System.out.println(Thread.currentThread().getName()+" increment value at "+counter.hashCode());
            try {
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
