package org.com.leetcode.printinorder;

import java.util.concurrent.Semaphore;

public class SemaphoreFoo {
    private Semaphore firstDone = new Semaphore(0);
    private Semaphore secondDone = new Semaphore(0);

    public SemaphoreFoo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();;
        firstDone.release(); // allow second() to proceed
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.acquire(); // wait for first() to release
        printSecond.run();
        secondDone.release(); // allow third() to proceed
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.acquire(); // wait for second() to release
        printThird.run();
    }
}
