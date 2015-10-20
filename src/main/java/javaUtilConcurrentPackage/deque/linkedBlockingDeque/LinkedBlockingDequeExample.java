package javaUtilConcurrentPackage.deque.linkedBlockingDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Example of using BlockingDeque with LinkedBlockingDeque implementation.
 * Allows insert and remove elements from both ends.
 * BlockingDeque extends BlockingQueue interface.
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 19:54
 */
public class LinkedBlockingDequeExample {

    public static void main(String[] args) {

        BlockingDeque<String> deque = new LinkedBlockingDeque<>();

        deque.addLast("1");
        deque.addFirst("2");

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
    }
}
