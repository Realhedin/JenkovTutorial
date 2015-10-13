package javaConcurrency.semaphores;

/**
 * Extended version of CountingSemaphore with upperBound.
 *
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 19:44
 */
public class BoundedSemaphore implements SemaphoreInterface {

    private int signals = 0;
    private int bound = 0;

    public BoundedSemaphore(int upperBound) {
        this.bound = upperBound;
    }

    public synchronized void take() {
        while (this.signals >= bound) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        this.signals++;
        this.notify();
    }

    public synchronized void release() {
        while (this.signals == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        this.signals--;
        this.notify();
    }

    @Override
    public int getSignals() {
        return signals;
    }
}
