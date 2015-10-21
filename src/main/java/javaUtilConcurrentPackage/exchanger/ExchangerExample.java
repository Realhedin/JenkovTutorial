package javaUtilConcurrentPackage.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Example of exchanging String objects between two threads.
 *
 * @author dkorolev
 *         Date: 21.10.15
 *         Time: 20:25
 */
public class ExchangerExample {

    public static void main(String[] args) {

        Exchanger<String> stringExchanger = new Exchanger<>();

        new Thread(new ExchangerRunnable<>(stringExchanger, "A")).start();
        new Thread(new ExchangerRunnable<>(stringExchanger, "B")).start();
    }
}
