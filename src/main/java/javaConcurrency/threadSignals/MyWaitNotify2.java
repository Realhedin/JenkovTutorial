package javaConcurrency.threadSignals;

/**
 * Improved class to protect lose of a thread signal.
 *
 * Created by dkorolev on 10/10/15.
 */
public class MyWaitNotify2 {

    final MonitorObject monitorObject = new MonitorObject();
    boolean wasSignaled = false;

    public void doWait() {
        synchronized (monitorObject) {
            if (!wasSignaled) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //clear signal and continue running
            wasSignaled = false;
        }
    }


    public void doNotify() {
        synchronized (monitorObject) {
            wasSignaled = true;
            monitorObject.notify();
        }
    }
}
