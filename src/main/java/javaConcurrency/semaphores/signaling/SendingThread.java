package javaConcurrency.semaphores.signaling;


import javaConcurrency.semaphores.SemaphoreInterface;

/**
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 19:37
 */
public class SendingThread extends Thread {
    SemaphoreInterface semaphore = null;

    public SendingThread(SemaphoreInterface semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName() +" | Sending:"+this.semaphore.getSignals());
            this.semaphore.take();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
