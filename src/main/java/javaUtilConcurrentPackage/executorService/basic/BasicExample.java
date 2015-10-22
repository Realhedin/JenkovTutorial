package javaUtilConcurrentPackage.executorService.basic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Example of basic method of ExecutorService.
 *
 * @author dkorolev
 *         Date: 22.10.15
 *         Time: 20:06
 */
public class BasicExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //basic execute with Runnable
        executorService.execute(() -> {
            System.out.println("The most basic variant");
            System.out.println();
        });


        //submit with Runnable
        Future future = executorService.submit(() -> System.out.println("Runnable submit variant"));
        if (future.get() == null) {
            System.out.println("Future == null => Everything is all right");
        } else {
            System.out.println("Houston, we have a problem.");
        }
        System.out.println();


        //submit with callable
        Future future1 = executorService.submit(() -> {
            System.out.println("Callable submit variant.");
            return "Callable future returned";
        });
        System.out.println("future1.get(): "+future1.get());
        System.out.println();


        //invokeAny (return one of the results)
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> "task 1");
        callables.add(() -> "task 2");
        callables.add(() -> "task 3");
        String result = executorService.invokeAny(callables);
        System.out.println("result: "+result);
        System.out.println();


        //invokeAll  (return list of future)
        //can't tell by future objects if all tasks successfully executed!
        List<Future<String>> futures = executorService.invokeAll(callables);
        for (Future<String> f : futures) {
            System.out.println("future.get(): "+f.get());
        }


        //shutdown
        executorService.shutdown();


    }
}
