package javaConcurrency.locks;

/**
 * Example of using both mechanism: Locks and Synchronized blocks.
 *
 * Created by dkorolev on 10/11/15.
 */
public class Example {

    public static void main(String[] args) {
        //CounterSynch counter = new CounterSynch();
        CounterLock counter = new CounterLock();

        new Thread(counter::inc).start();
        new Thread(counter::inc).start();
        new Thread(counter::inc).start();
        new Thread(counter::inc).start();
        new Thread(counter::inc).start();
    }
}
