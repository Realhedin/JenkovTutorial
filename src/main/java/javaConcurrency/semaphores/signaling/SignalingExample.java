package javaConcurrency.semaphores.signaling;

import javaConcurrency.semaphores.BoundedSemaphore;

/**
 * Example of signaling use case of semaphore.
 *
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 19:36
 */
public class SignalingExample {

    public static void main(String[] args) {
        //CountingSemaphore cs = new CountingSemaphore();
        BoundedSemaphore cs = new BoundedSemaphore(5);

        new SendingThread(cs).start();
        new ReceivingThread(cs).start();
    }
}
