package javaConcurrency.blockingQueue;

/**
 * Example of working with BlockingQueue.
 * where parameter is limit on items in the queue.
 *
 * @author dkorolev
 *         Date: 13.10.15
 *         Time: 20:54
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        SimpleBlockingQueue simpleBlockingQueue = new SimpleBlockingQueue(10);

        //put in a queue
        new Thread(() -> {
            while (true) {
                simpleBlockingQueue.enqueue((Math.random() * 10));
                System.out.println("Enqueue | size:" + simpleBlockingQueue.getQueueSize());
                try {
                    Thread.sleep((long) (Math.random() * 1500));
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        }).start();


        //get from a queue
        new Thread(() -> {
            while (true) {
                System.out.print("Dequeue | item:"+simpleBlockingQueue.dequeue());
                System.out.println(" | size:" + simpleBlockingQueue.getQueueSize());
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        }).start();
    }
}
