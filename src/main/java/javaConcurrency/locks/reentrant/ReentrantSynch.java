package javaConcurrency.locks.reentrant;

/**
 * Reentrant class with synchronized methods.
 *
 * Created by dkorolev on 10/11/15.
 */
public class ReentrantSynch {

    private int counter = 0;


    public synchronized void outer() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " | count:"+counter);
        inner();
    }

    public synchronized void inner() {
        counter*=2;
        System.out.println(Thread.currentThread().getName() + " | count:"+counter);
    }
}
