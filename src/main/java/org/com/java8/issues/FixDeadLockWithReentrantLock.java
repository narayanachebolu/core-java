package org.com.java8.issues;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FixDeadLockWithReentrantLock {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1() {
        lock1.lock();

        try {
            System.out.println("Locked lock1 in method1.");
            lock2.lock();
            try {
                System.out.println("Locked lock2 in method1.");
            } finally {
                lock2.unlock();
            }
        } finally {
            lock1.unlock();
        }
    }

    public void method2() {
        lock1.lock();

        try {
            System.out.println("Locked lock1 in method2.");
            lock2.lock();
            try {
                System.out.println("Locked lock2 in method2.");
            } finally {
                lock2.unlock();
            }
        } finally {
            lock1.unlock();
        }
    }

    public static void main(String[] args) {
        FixDeadLockWithReentrantLock fixDeadLockWithReentrantLock = new FixDeadLockWithReentrantLock();

        Thread thread1 = new Thread(fixDeadLockWithReentrantLock::method1);
        Thread thread2 = new Thread(fixDeadLockWithReentrantLock::method2);

        thread1.start();
        thread2.start();
    }
}
