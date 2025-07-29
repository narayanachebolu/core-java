package org.com.leetcode.printinorder;

import java.util.concurrent.CountDownLatch;

/**
 * One clean way to solve this is with CountDownLatch from java.util.concurrent. Here’s how it works:
 * You create two latches:
 *   firstDone — lets second() wait until first() is done.
 *   secondDone — lets third() wait until second() is done.
 */
public class CountDownLatchFoo {
    private final CountDownLatch firstDone;
    private final CountDownLatch secondDone;

    public CountDownLatchFoo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.countDown(); // let second() proceed
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstDone.await(); // wait for first() to finish
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.countDown(); // let third() proceed
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondDone.await(); // wait for second() to finish
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
