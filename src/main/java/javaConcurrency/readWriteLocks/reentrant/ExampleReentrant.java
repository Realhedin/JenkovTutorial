package javaConcurrency.readWriteLocks.reentrant;

import javaConcurrency.readWriteLocks.IncrementClass;

/**
 * Example using ReadWriteLock with reentrance.
 * <p>
 * Created by dkorolev on 10/11/15.
 */
public class ExampleReentrant {

    public static void main(String[] args) {

        IncrementClass incrementClass = new IncrementClass();
        ReadWriteLock readWriteLock = new ReadWriteLock();


        new Thread(() -> {
            readWriteLock.lockRead();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.unlockRead();
            }
            System.out.println(incrementClass.getCounter());
            readWriteLock.unlockRead();
        }).start();


        new Thread(() -> {
            readWriteLock.lockWrite();
            incrementClass.inc();
            System.out.println("Counter incremented!");
            readWriteLock.unlockWrite();
        }).start();


        new Thread(() -> {
            readWriteLock.lockRead();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.unlockRead();
            }
            System.out.println(incrementClass.getCounter());
            readWriteLock.unlockRead();
        }).start();

        new Thread(() -> {
            readWriteLock.lockRead();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readWriteLock.unlockRead();
            }
            System.out.println(incrementClass.getCounter());
            readWriteLock.unlockRead();
        }).start();


        new Thread(() -> {
            readWriteLock.lockWrite();
            incrementClass.inc();
            System.out.println("Counter incremented!");
            readWriteLock.unlockWrite();
        }).start();

    }
}
