package javaConcurrency.threadSignals;

/**
 * Changes to the class for MultiThreaded example.
 *
 * Created by dkorolev on 10/10/15.
 */
public class MultiMyWaitNotify4 {

    final MonitorObject monitorObject = new MonitorObject();
    boolean wasSignaled = false;

    public void doWait() {
        synchronized (monitorObject) {
            while (!wasSignaled) {
                System.out.println(Thread.currentThread().getName() + " is going to wait.");
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //clear signal and continue
            wasSignaled = false;
            System.out.println(Thread.currentThread().getName() + " is awaken by another thread.");
        }
    }

    public void doNotify() {
        do {
            synchronized (monitorObject) {
                wasSignaled = true;
                System.out.println(Thread.currentThread().getName() + " is going to notify.");
                monitorObject.notifyAll();
                System.out.println(Thread.currentThread().getName() + " sent notify.");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!wasSignaled);
    }
}
