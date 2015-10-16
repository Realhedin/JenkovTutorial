package javaConcurrency.nonBlockingAlgorithms;

/**
 * Example of using of SingleWriterCounter class
 * to allow only one writer and any number of readers.
 *
 * @author dkorolev
 *         Date: 16.10.15
 *         Time: 14:40
 */
public class ExampleNonBlocking1 {

    public static void main(String[] args) {
        SingleWriterCounter counter1 = new SingleWriterCounter();
        SingleWriterCounter counter2 = new SingleWriterCounter();


        new NonBlockingThreadReader(counter1).start();
        new NonBlockingThreadReader(counter1).start();
        new NonBlockingThreadReader(counter2).start();
        new NonBlockingThreadReader(counter2).start();

        new NonblockingThreadWriter(counter1).start();
        new NonblockingThreadWriter(counter2).start();

    }
}
