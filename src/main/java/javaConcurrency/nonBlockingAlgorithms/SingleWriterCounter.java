package javaConcurrency.nonBlockingAlgorithms;

/**
 * Class correctly works on using , if
 * there is only 1 writer and any number of readers.
 * Show work of volatile variable.
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 14:38
 */
public class SingleWriterCounter {

    private volatile long count = 0;

    //only one thread can do this.
    public void inc() {
        this.count++;
    }


    //each thread can do it.
    public long getCount() {
        return this.count;
    }
}
