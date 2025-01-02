package org.com.java8.challenges.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TimeMeasurementExample {
    private static final Logger LOG = LoggerFactory.getLogger(TimeMeasurementExample.class);

    public static void main(String[] args) {
        elapsedTimeInNanoSeconds();

        elapsedTimeInMilliSeconds();
    }
    private static void elapsedTimeInMilliSeconds() {
        long startTime = System.currentTimeMillis();

        executeTask();

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        System.out.println("Time taken to execute a thread: " + elapsedTime);
    }

    private static void elapsedTimeInNanoSeconds() {
        long startTime = System.nanoTime();

        executeTask();

        long endTime = System.nanoTime();

        long elapseTime = endTime - startTime;
        System.out.println("Time taken to execute the thread (Higher Resolution Timer - nano seconds): " + elapseTime);

        System.out.println("Time taken to execute the thread: " + elapseTime / 1_000_000);

    }

    private static void executeTask() {
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException ix) {
            LOG.error("Exception while executing task. " + ix.getMessage());
        }
    }
}
