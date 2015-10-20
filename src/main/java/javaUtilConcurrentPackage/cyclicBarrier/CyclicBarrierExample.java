package javaUtilConcurrentPackage.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Example of CyclicBarrier with 2 threads.
 * Each of barriers will be tripped when both threads
 * come to it.
 * (first arrived will be waiting for the second one.)
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 21:04
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier barrier1 = new CyclicBarrier(2, () -> System.out.println("BarrierAction 1 executed"));
        CyclicBarrier barrier2 = new CyclicBarrier(2, () -> System.out.println("BarrierAction 2 executed"));


        new Thread(new CyclicBarrierRunnable(barrier1, barrier2)).start();
        new Thread(new CyclicBarrierRunnable(barrier1, barrier2)).start();

    }
}
