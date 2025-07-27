package org.com.java8.threads;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started..");
            int c = 0;
            while (c < 3) {
                System.out.println(c + " message.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                c++;
            }
        });

        t1.start();
        Thread.sleep(2000);
        System.out.println("Main thread done.");
    }
}
