package javaConcurrency.semaphores.lock;

import javaConcurrency.semaphores.SemaphoreInterface;

/**
 * Convenient realisation of working thread from LockExample.
 *
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 20:19
 */
public class LockThreadWithSem extends Thread{

      private SemaphoreInterface semaphoreInterface;


    public LockThreadWithSem(SemaphoreInterface semaphoreInterface) {
        this.semaphoreInterface = semaphoreInterface;
    }


    @Override
    public void run() {
        while (true) {
            semaphoreInterface.take();
            try {
                System.out.println(Thread.currentThread().getName() + " | " + semaphoreInterface.getSignals());
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            finally {
                semaphoreInterface.release();
            }
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
