package org.com.leetcode.printinorder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionFoo {
    private final Lock lock = new ReentrantLock();
    private final Condition firstDone = lock.newCondition();
    private final Condition secondDone = lock.newCondition();
    private int step = 1;

    public LockConditionFoo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            step = 2;
            firstDone.signal(); // notify second()
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (step != 2) {
                firstDone.await(); // wait for first() to signal
            }
            printSecond.run();
            step = 3;
            secondDone.signal(); // notify third()
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (step != 3) {
                secondDone.await(); // wait for second() to signal
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
