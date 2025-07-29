package org.com.leetcode.printinorder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMultipleRoundsWithThreads {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            LockConditionFoo lockConditionFoo = new LockConditionFoo();
            StringBuilder outputStringBuilder = new StringBuilder();

            List<Thread> threadList = getThreadList(lockConditionFoo, outputStringBuilder);
            Collections.shuffle(threadList);

            for (Thread t : threadList) {
                t.start();
            }

            for (Thread t : threadList) {
                t.join(); // wait for all to finish
            }

            String result = outputStringBuilder.toString();
            System.out.println("Run #" + i + ": " + result);
            if (!result.equals("First.Second.Third.")) {
                throw new AssertionError("Test failed! Got: " + result);
            }
        }
    }

    private static List<Thread> getThreadList(LockConditionFoo lockConditionFoo, StringBuilder outputStringBuilder) {
        Thread t1 = new Thread(() -> {
           try {
               lockConditionFoo.first(() -> outputStringBuilder.append("First."));
           } catch (InterruptedException ix) {
               Thread.currentThread().interrupt();
           }
        });

        Thread t2 = new Thread(() -> {
            try {
                lockConditionFoo.second(() -> outputStringBuilder.append("Second."));
            } catch (InterruptedException ix) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                lockConditionFoo.third(() -> outputStringBuilder.append("Third."));
            } catch (InterruptedException ix) {
                Thread.currentThread().interrupt();
            }
        });

        return Arrays.asList(t1, t2, t3);
    }
}
