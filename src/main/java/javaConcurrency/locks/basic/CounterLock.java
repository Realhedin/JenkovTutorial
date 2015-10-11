package javaConcurrency.locks.basic;

/**
 * Class with implementation of method inc() with locks.
 *
 * Created by dkorolev on 10/11/15.
 */
public class CounterLock {

    private int count = 0;
    private LockHand lockHand = new LockHand();

    public int inc() {
        lockHand.lock();
        System.out.println(Thread.currentThread().getName() + " took lock");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int newCount = ++count;
        System.out.println(Thread.currentThread().getName() + " | newCount:"+newCount);
        System.out.println(Thread.currentThread().getName() + " released lock");
        lockHand.unlock();
        return newCount;
    }

}
