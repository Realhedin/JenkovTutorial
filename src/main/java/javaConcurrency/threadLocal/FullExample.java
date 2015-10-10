package javaConcurrency.threadLocal;

/**
 * Created by dkorolev on 10/10/15.
 */
public class FullExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Double> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set(Math.random() * 100D);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
