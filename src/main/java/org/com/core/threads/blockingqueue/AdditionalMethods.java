package org.com.core.threads.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * https://jenkov.com/tutorials/java-util-concurrent/blockingqueue.html
 */
public class AdditionalMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

        int queueSize = blockingQueue.size();

        int remainingCapacity = blockingQueue.remainingCapacity();

        // uses equals method
        boolean containsElement = blockingQueue.contains("1");
    }
}
