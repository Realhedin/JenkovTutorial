package javaConcurrency.readWriteLocks.basic;

/**
 * Simple implementation of ReadWriteLock.
 * Read Access: no thread is writing or request for writing.
 * Write Access: not thread is reading or writing.
 *
 * Created by dkorolev on 10/11/15.
 */
public class ReadWriteLock {
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;


    public synchronized void lockRead() {
        while (writers > 0 || writeRequests > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }


    public synchronized void lockWrite() {
        writeRequests++;
        while (readers > 0 || writers > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }
}
