package javaConcurrency.threadSignals;

/**
 * Example show the simple work of wait() and notify()
 * with 2 threads.
 * MyWaitNotify - simple realisation of business logic.
 * MyWaitNotify2 - add protection from missing a signal.
 * MyWaitNotify3 - protect from spurious wakeups.
 *
 * Created by dkorolev on 10/10/15.
 */
public class Example {

    public static void main(String[] args) {

//       MyWaitNotify myWaitNotify = new MyWaitNotify();
//        MyWaitNotify2 myWaitNotify = new MyWaitNotify2();
        MyWaitNotify3 myWaitNotify = new MyWaitNotify3();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
            System.out.println(Thread.currentThread().getName() + " is going to wait.");
            //works only for MyWaitNotify2 and 3
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myWaitNotify.doWait();
            System.out.println(Thread.currentThread().getName() + " is awaken by another thread.");
        }).start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is going to notify.");
            myWaitNotify.doNotify();
            System.out.println(Thread.currentThread().getName() + " sent notify.");
        }).start();
    }
}
