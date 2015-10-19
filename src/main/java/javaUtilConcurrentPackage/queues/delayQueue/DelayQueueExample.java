package javaUtilConcurrentPackage.queues.delayQueue;

import java.util.concurrent.DelayQueue;

/**
 * Example of using DelayQueue
 *
 * @author dkorolev
 *         Date: 19.10.15
 *         Time: 20:03
 */
public class DelayQueueExample {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        DelayedElement el1 = new DelayedElement("test");
        DelayedElement el2 = new DelayedElement("element");

        queue.put(el1);
        queue.put(el2);


        DelayedElement el3 = queue.take();
        System.out.println(el3.getValue());

        el3 = queue.take();
        System.out.println(el3.getValue());
    }
}
