package org.com.java8.issues;

public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println("Locked lock1 in method1.");
            synchronized (lock2) {
                System.out.println("Locked lock2 in method1 after locking lock1.");
            }
        }
    }

    public void method2() {
        synchronized (lock1) {
            System.out.println("Locked lock1 in method2.");
            synchronized (lock2) {
                System.out.println("Locked lock2 in method2 after locking lock1.");
            }
        }
    }

    /**
     * causes method lock due to inconsistent locking order. Locked lock2 first and then lock1.
     * Refer method2() for correct locking order: which consistent with method1().
     */
    public void method3() {
        synchronized (lock2) {
            System.out.println("Locked lock2 in method3.");
            synchronized (lock1) {
                System.out.println("Locked lock1 in method3 after locking lock2.");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        Runnable task1 = deadLock::method1;
        Runnable task2 = deadLock::method2;

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
