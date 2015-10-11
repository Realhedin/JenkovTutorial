package javaConcurrency.locks.reentrant;

/**
 * Implementation of a lock with reentrance.
 * We add to loop check which thread has already lock,
 * if it is the same than allow execution.
 * Also inner counter is needed for releasing lock
 * either completely or not.
 *
 * Created by dkorolev on 10/11/15.
 */
public class LockHandReentrant {

    private boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() {
        Thread callingThread = Thread.currentThread();
        while (isLocked && lockedBy != callingThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
        //do some stuff
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;

            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }

    }
}
