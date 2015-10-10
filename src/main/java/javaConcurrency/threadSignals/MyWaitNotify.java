package javaConcurrency.threadSignals;

/**
 * Class than has business logic with wait() and notify().
 *
 * Created by dkorolev on 10/10/15.
 */
public class MyWaitNotify {

    final MonitorObject monitorObject = new MonitorObject();

    public void doWait() {
        synchronized (monitorObject){
            try {
                monitorObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            monitorObject.notify();
        }
    }
}
