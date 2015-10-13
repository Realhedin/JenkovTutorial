package javaConcurrency.semaphores.signaling;

import javaConcurrency.semaphores.SemaphoreInterface;

/**
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 19:39
 */
public class ReceivingThread extends Thread{

    SemaphoreInterface semaphore = null;

    public ReceivingThread(SemaphoreInterface semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            this.semaphore.release();
            System.out.println(Thread.currentThread().getName() + " | Receiving:"+this.semaphore.getSignals());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
