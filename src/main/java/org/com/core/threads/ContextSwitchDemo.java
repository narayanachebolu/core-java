package org.com.core.threads;

public class ContextSwitchDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
               long sum = 0;
               for (int j = 0; j < 1000000; j++) {
                   sum += j;
               }
                System.out.println("Sum: " + sum);
            });
        }

        long start = System.currentTimeMillis();

        for(Thread thread : threads) thread.start();
        for(Thread thread: threads) thread.join();

        long end = System.currentTimeMillis();
        System.out.println("Finished in: " + (end - start) + "ms.");
    }
}
