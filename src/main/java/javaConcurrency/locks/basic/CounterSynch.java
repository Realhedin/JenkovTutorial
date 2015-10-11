package javaConcurrency.locks.basic;

/**
 * Class with synchronized block for inc().
 *
 * Created by dkorolev on 10/11/15.
 */
public class CounterSynch {

    private int count = 0;

    public int inc() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " | count:"+(count+1));
            return ++count;
        }
    }
}
