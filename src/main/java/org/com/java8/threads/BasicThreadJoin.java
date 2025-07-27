package org.com.java8.threads;

/**
 * Basic Thread Join
 *   - Start 2 threads that each take 2 seconds to finish.
 *   - Use join() to make main wait until both finish and then print “All done”.
 */
public class BasicThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ix) {
                ix.printStackTrace();
            }
            System.out.println("Thread 1 done.");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ix) {
                ix.printStackTrace();
            }
            System.out.println("Thread 2 done.");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("All done.");
    }
}
