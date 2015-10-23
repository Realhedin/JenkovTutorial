package javaUtilConcurrentPackage.executorService.sheduledExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Example of ScheduledExecutorService.
 * Allows to schedule execution with a delay
 * or do them repeatedly with some delay.
 *
 * @author dkorolev
 *         Date: 22.10.15
 *         Time: 20:34
 */
public class ScheduledExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        //start execution with 2 seconds delay
        ScheduledFuture<String> scheduledFuture = scheduledExecutorService
                .schedule(() -> {
                    System.out.println("Executed!");
                    return "called!";
                }
                ,2 , TimeUnit.SECONDS);
        System.out.println("ScheduledFuture: " + scheduledFuture.get());

        //period - time between end(!) of previous execution and begin of next one
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("scheduleWithFixedDelay")
                , 0, 1, TimeUnit.SECONDS);

        //period - time between start(!) of previous execution and begin of next one
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("scheduleAtFixedRate")
                , 0, 1, TimeUnit.SECONDS);


        Thread.sleep(3000);

        scheduledExecutorService.shutdown();

    }
}
