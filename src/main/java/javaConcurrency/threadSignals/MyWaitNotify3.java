package javaConcurrency.threadSignals;

/**
 * Improved of version2 to protect from spurious wakeups.
 * <p>
 * Created by dkorolev on 10/10/15.
 */
public class MyWaitNotify3 {

    final MonitorObject monitorObject = new MonitorObject();
    boolean wasSignaled = false;

    public void doWait() {
        synchronized (monitorObject) {
            while (!wasSignaled) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //clear signal and continue
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
