package org.com.leetcode.printinorder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMultipleRoundsWithExecutorService {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            SemaphoreFoo semaphoreFoo = new SemaphoreFoo();
            StringBuilder outputStringBuilder = new StringBuilder();

            ExecutorService executorService = Executors.newFixedThreadPool(3);

            // put them in a list to randomize the order
            List<Runnable> tasks = Arrays.asList(
                    () -> {
                        try {
                            System.out.println("Calling first.");
                            semaphoreFoo.first(() -> outputStringBuilder.append("First."));
                        } catch (InterruptedException ix) {
                            Thread.currentThread().interrupt();
                        }
                    },
                    () -> {
                        try {
                            System.out.println("Calling second.");
                            semaphoreFoo.second(() -> outputStringBuilder.append("Second."));
                        } catch (InterruptedException ix) {
                            Thread.currentThread().interrupt();
                        }
                    },
                    () -> {
                        try {
                            System.out.println("Calling third.");
                            semaphoreFoo.third(() -> outputStringBuilder.append("Third."));
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

            // wait for task to finish
            while (!executorService.isTerminated()) {
                Thread.sleep(10);
            }

            String result = outputStringBuilder.toString();
            System.out.println("Run #: " + (i + 1) + ": " + result);

            if (!result.equals("First.Second.Third.")) {
                throw new AssertionError("Test failed! Got: " + result);
            }
        }
        System.out.println("All tests passed..");
    }
}
