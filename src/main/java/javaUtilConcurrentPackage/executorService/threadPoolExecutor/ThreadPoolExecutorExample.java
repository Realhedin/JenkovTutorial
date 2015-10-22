package javaUtilConcurrentPackage.executorService.threadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Example of a ThreadPoolExecutor.
 * Useful when we really need all these parameters,
 * otherwise more convenient to use one of the factory methods.
 *
 * @author dkorolev
 *         Date: 22.10.15
 *         Time: 20:28
 */
public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;

        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.execute(() -> System.out.println("Test with ThreadPoolExecutor"));
    }
}
