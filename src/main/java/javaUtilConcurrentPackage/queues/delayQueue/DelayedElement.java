package javaUtilConcurrentPackage.queues.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of delayed interface.
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 20:01
 */
public class DelayedElement implements Delayed {

    private String value;

    public DelayedElement(String value) {
        this.value = value;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = (long) (Math.random() * 10);
        System.out.println(delay);
        return unit.toSeconds(delay);
    }


    @Override
    public int compareTo(Delayed o) {
        return (int)o.getDelay(TimeUnit.SECONDS);
    }


    public String getValue() {
        return value;
    }
}
