package org.com.java8.threads;

public class RunMultipleThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("My name is " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++)
                System.out.println("Message " + i);
        }, "Thread 1");
        Thread t2 = new Thread(() -> {
            System.out.println("My name is " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++)
                System.out.println("Message " + i);
        }, "Thread 2");
        Thread t3 = new Thread(() -> {
            System.out.println("My name is " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++)
                System.out.println("Message " + i);
        }, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
