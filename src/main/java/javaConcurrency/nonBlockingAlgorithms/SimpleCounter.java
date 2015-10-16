package javaConcurrency.nonBlockingAlgorithms;

/**
 * General interface for implementation.
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 16:07
 */
public interface SimpleCounter {

    public void inc();

    public long getCount();
}
