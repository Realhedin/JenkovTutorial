package javaConcurrency.nonBlockingAlgorithms.volatileOneWriterManyReaders;

import javaConcurrency.nonBlockingAlgorithms.SimpleCounter;

/**
 * Thread that reads from volatile variable.
 * Each object can use the same SingleWriterCounter object
 * because volatile variable is read directly from RAM.
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 14:44
 */
public class NonBlockingThreadReader extends Thread {

    private SimpleCounter counter;


    public NonBlockingThreadReader(SimpleCounter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+" | count"+counter.getCount()+" | at "+counter.hashCode());
            try {
                Thread.sleep((long)(Math.random()*5000));
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
