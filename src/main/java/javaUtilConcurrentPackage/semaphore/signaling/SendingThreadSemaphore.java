package javaUtilConcurrentPackage.semaphore.signaling;

import java.util.concurrent.Semaphore;

/**
 * Acquires a lock.
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 21:02
 */
public class SendingThreadSemaphore implements Runnable {
    Semaphore semaphore = null;

    public SendingThreadSemaphore(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            try {
                System.out.println(Thread.currentThread().getName() +" | Sending:"+this.semaphore.availablePermits());
                this.semaphore.acquire();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
