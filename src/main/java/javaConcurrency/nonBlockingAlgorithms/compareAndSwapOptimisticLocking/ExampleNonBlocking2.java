package javaConcurrency.nonBlockingAlgorithms.compareAndSwapOptimisticLocking;

import javaConcurrency.nonBlockingAlgorithms.volatileOneWriterManyReaders.NonBlockingThreadReader;
import javaConcurrency.nonBlockingAlgorithms.volatileOneWriterManyReaders.NonblockingThreadWriter;

/**
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 16:12
 */
public class ExampleNonBlocking2 {

    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();


        new NonBlockingThreadReader(counter).start();
        new NonBlockingThreadReader(counter).start();

        new NonblockingThreadWriter(counter).start();
        new NonblockingThreadWriter(counter).start();
        new NonblockingThreadWriter(counter).start();
        new NonblockingThreadWriter(counter).start();
    }
}
