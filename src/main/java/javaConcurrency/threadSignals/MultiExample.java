package javaConcurrency.threadSignals;

/**
 * Example when multi threads are waiting on a monitor object.
 *
 * Created by dkorolev on 10/10/15.
 */
public class MultiExample {

    public static void main(String[] args) {

        MultiMyWaitNotify4 myWaitNotify = new MultiMyWaitNotify4();


        //waiting threads
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myWaitNotify.doWait();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myWaitNotify.doWait();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myWaitNotify.doWait();
        }).start();


        //notifying thread
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
            myWaitNotify.doNotify();
        }).start();
    }
}
