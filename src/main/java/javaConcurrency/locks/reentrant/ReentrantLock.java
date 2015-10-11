package javaConcurrency.locks.reentrant;

/**
 * Reentrant class with locks.
 *
 * Created by dkorolev on 10/11/15.
 */
public class ReentrantLock {

    private int counter = 0;
    LockHandReentrant lockHandReentrant = new LockHandReentrant();

    public void outer() {
        lockHandReentrant.lock();
        counter++;
        System.out.println(Thread.currentThread().getName() + " | count:"+counter);
        inner();
        lockHandReentrant.unlock();
    }

    public synchronized void inner() {
        lockHandReentrant.lock();
        counter*=3;
        System.out.println(Thread.currentThread().getName() + " | count:"+counter);
        lockHandReentrant.unlock();
    }
}
