package org.com.designpatterns.singleton;

public class ThreadSafetyTest {
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton singletonInstance = Singleton.INSTANCE;
            singletonInstance.printHashcode();
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
