package org.com.core.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    //blockingQueue.add(i); // throws exception if full.
                    blockingQueue.put(i); // doesn't throw exception, rather it waits.
                }
            } catch (InterruptedException ix) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    //System.out.println("Consumed: " + blockingQueue.poll()); // returns null if empty.
                    System.out.println("Consumed: " + blockingQueue.take()); // wait for a value when the queue is empty.
                }
            } catch (InterruptedException ix) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
