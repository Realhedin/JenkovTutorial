package javaUtilConcurrentPackage.semaphore.signaling;

import java.util.concurrent.Semaphore;

/**
 * Releases the lock.
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 21:01
 */
public class ReceivingThreadSemaphore implements Runnable {

    Semaphore semaphore = null;

    public ReceivingThreadSemaphore(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            try {
                this.semaphore.release();
                System.out.println(Thread.currentThread().getName() + " | Receiving:"+this.semaphore.availablePermits());
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
