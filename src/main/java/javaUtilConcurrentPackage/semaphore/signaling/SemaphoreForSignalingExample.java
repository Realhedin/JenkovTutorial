package javaUtilConcurrentPackage.semaphore.signaling;

import java.util.concurrent.Semaphore;

/**
 * Example of usage of semaphore as signaling between objects.
 * Use fair flag for fairness.
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 21:00
 */
public class SemaphoreForSignalingExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10,true);

        new Thread(new SendingThreadSemaphore(semaphore)).start();
        new Thread(new SendingThreadSemaphore(semaphore)).start();
        new Thread(new ReceivingThreadSemaphore(semaphore)).start();
        new Thread(new ReceivingThreadSemaphore(semaphore)).start();

    }
}
