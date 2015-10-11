package javaConcurrency.locks.reentrant;

/**
 * Example of reentrance implementation of both: synchronized and locks.
 *
 * Created by dkorolev on 10/11/15.
 */
public class ExampleReentrant {

    public static void main(String[] args) {
//        ReentrantSynch counter = new ReentrantSynch();
        ReentrantLock counter = new ReentrantLock();

        new Thread(counter::outer).start();
        new Thread(counter::outer).start();
        new Thread(counter::outer).start();
        new Thread(counter::outer).start();
        new Thread(counter::outer).start();
    }
}
