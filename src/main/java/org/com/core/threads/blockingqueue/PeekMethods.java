package org.com.core.threads.blockingqueue;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue interface has a method to just look at the first element in queue without removing it.
 * It will return NULL if there are no elements.
 */
public class PeekMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

        String element = blockingQueue.peek();

        try {
            String element1 = blockingQueue.element();
        } catch (NoSuchElementException nsex) {
            System.out.println("BlockingQueue is empty.");
        }
    }
}
