package javaConcurrency.nonBlockingAlgorithms.compareAndSwapOptimisticLocking;

import javaConcurrency.nonBlockingAlgorithms.SimpleCounter;

/**
 * Simple many writers implementation of Counter
 * using synchronized blocks.
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 15:53
 */
public class SynchronizedCounter implements SimpleCounter {

    private long count = 0;

    public void inc() {
        synchronized (this) {
            count++;
        }
    }

    public long getCount() {
        synchronized (this) {
            return this.count;
        }
    }
}
