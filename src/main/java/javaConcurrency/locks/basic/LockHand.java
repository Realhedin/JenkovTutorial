package javaConcurrency.locks.basic;

/**
 * Simple lock implementation by hand.
 *
 * Created by dkorolev on 10/11/15.
 */
public class LockHand {

    private boolean isLocked = false;

    public synchronized void lock() {
        while(isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        //do some stuff
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
