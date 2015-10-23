package javaUtilConcurrentPackage.forkAndJoinPool;

import java.util.concurrent.ForkJoinPool;

/**
 * Example of using ForkJoinPool.
 * with RecursiveAction implementation
 * and RecursiveTask implementation.
 *
 * @author dkorolev
 *         Date: 23.10.15
 *         Time: 20:01
 */
public class ForkJoinPoolExample {

    public static void main(String[] args) throws InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        //executing RecursiveActions.
        System.out.println("RecursiveActions:");
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(32);
        forkJoinPool.invoke(myRecursiveAction);

        //Pause
        Thread.sleep(1000);
        System.out.println();

        //executing RecursiveTasks.
        System.out.println("RecursiveTasks:");
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(63);
        Long mergeResult = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("mergedResult = " + mergeResult);
    }
}
