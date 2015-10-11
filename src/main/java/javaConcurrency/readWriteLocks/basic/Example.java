package javaConcurrency.readWriteLocks.basic;

import javaConcurrency.readWriteLocks.IncrementClass;

/**
 * Example for basic readWriteLock implementation.
 *
 * Created by dkorolev on 10/11/15.
 */
public class Example {

    public static void main(String[] args) {

        IncrementClass incrementClass = new IncrementClass();
        ReadWriteLock readWriteLock = new ReadWriteLock();


        new Thread(() -> {
            readWriteLock.lockRead();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
