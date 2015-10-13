package javaConcurrency.semaphores;

/**
 * Basic interface of semaphore to implement.
 *
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 19:52
 */
public interface SemaphoreInterface {

    public void take();

    public void release();

    public int getSignals();
}
