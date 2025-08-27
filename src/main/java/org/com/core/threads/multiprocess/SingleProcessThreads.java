package org.com.core.threads.multiprocess;

public class SingleProcessThreads {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " , PID: " + ProcessHandle.current().pid());
        };

        Thread thread1 = new Thread(task, "Worker-1");
        Thread thread2 = new Thread(task, "Worker-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Main PID: " + ProcessHandle.current().pid());
    }
}
