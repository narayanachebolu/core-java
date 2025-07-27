package org.com.java8.threads;

public class CombineSleepJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int[] n = {0, 1, 2};
            for (int i = 0; i < n.length; i++) {
                System.out.println("Thread 1: " + n[i]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            char[] c = {'a', 'b', 'c'};
            for (int i = 0; i < c.length; i++) {
                System.out.println("Thread 1: " + c[i]);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("Main halfway..");
        t1.join();
        t2.join();
        System.out.println("Main done..");
    }
}
