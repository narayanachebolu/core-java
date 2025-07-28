package org.com.leetcode.printinorder;

public class SynchronizedWaitNotifyFoo {
    private int step = 1;

    public SynchronizedWaitNotifyFoo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            printFirst.run();
            step = 2;
            notifyAll(); // wake up waiting threads
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (step != 2) {
                wait();
            }
            printSecond.run();
            step = 3;
            notifyAll(); // wake up waiting threads
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (step != 3) {
                wait();
            }
            printThird.run();
        }
    }

}
