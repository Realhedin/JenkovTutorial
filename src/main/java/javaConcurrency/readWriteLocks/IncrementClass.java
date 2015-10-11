package javaConcurrency.readWriteLocks;

/**
 * POJO class to increment/get counter.
 *
 * Created by dkorolev on 10/11/15.
 */
public class IncrementClass {

    private int counter = 0;

    public void inc() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
