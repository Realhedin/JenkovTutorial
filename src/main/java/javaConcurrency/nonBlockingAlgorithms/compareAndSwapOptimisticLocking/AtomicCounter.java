package javaConcurrency.nonBlockingAlgorithms.compareAndSwapOptimisticLocking;

import javaConcurrency.nonBlockingAlgorithms.SimpleCounter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Simple atomic implementation of a Counter
 * using CompareAndSwap (atomic operations)
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 15:54
 */
public class AtomicCounter implements SimpleCounter{

    private AtomicLong count = new AtomicLong();

    public void inc() {
        boolean updated = false;
        while (!updated) {
            long prevCount = this.count.get();
            updated = this.count.compareAndSet(prevCount, prevCount + 1);
        }
    }

    public long getCount() {
        return this.count.get();
    }
}
