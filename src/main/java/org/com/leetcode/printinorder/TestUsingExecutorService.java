package org.com.leetcode.printinorder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestUsingExecutorService {
    public static void main(String[] args) {
        CountDownLatchFoo countDownLatchFoo = new CountDownLatchFoo();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // runnables for each method
        Runnable printFirst = () -> System.out.println("First.");
        Runnable printSecond = () -> System.out.println("Second.");
        Runnable printThird = () -> System.out.println("Third.");

        // put them in a list to randomize the order
        List<Runnable> tasks = Arrays.asList(
                () -> {
                    try {
                        System.out.println("Calling first.");
                        countDownLatchFoo.first(printFirst);
                    } catch (InterruptedException ix) {
                        Thread.currentThread().interrupt();
                    }
                },
                () -> {
                    try {
                        System.out.println("Calling second.");
                        countDownLatchFoo.second(printSecond);
                    } catch (InterruptedException ix) {
                        Thread.currentThread().interrupt();
                    }
                },
                () -> {
                    try {
                        System.out.println("Calling third.");
                        countDownLatchFoo.third(printThird);
                    } catch (InterruptedException ix) {
                        Thread.currentThread().interrupt();
                    }
                }
        );

        // shuffle to simulate random thread start order
        Collections.shuffle(tasks);

        // submit tasks to executor
        for (Runnable task : tasks) {
            executorService.submit(task);
        }

        // shut down executor - manual cleanup for classic pools
        executorService.shutdown();
    }
}
