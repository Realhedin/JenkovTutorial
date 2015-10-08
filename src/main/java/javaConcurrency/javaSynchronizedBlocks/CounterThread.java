package javaConcurrency.javaSynchronizedBlocks;

/**
 * @author dkorolev
 *         Date: 08.10.15
 *         Time: 19:57
 */
public class CounterThread extends Thread {

    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }


    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
    }
}
