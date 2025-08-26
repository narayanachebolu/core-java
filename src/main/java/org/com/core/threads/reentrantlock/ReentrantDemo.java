package org.com.core.threads.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * how to use ReentrantLock to prevent race conditions when accessing a shared counter.
 *
 * Explanation: In the below demo, the shared resource "c" is accessed by multiple threads to increment the value. The
 * Reentrant lock object ensures only one thread access the resource "c" at a time, there by preventing the race
 * condition. "reentrantLock.lock();" acquires the lock and "reentrantLock.unlock();" in the finally block ensures
 * to release the lock even when an exception is thrown.
 */
public class ReentrantDemo {
    // lock object
    private final static ReentrantLock reentrantLock = new ReentrantLock();

    // shared resource
    private static int counter = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }

    // task
    public static void increment() {

        reentrantLock.lock();

        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        } finally {
            // release the lock.
            reentrantLock.unlock();
        }
    }
}
