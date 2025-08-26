package org.com.core.threads.blockingqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DrainMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        Collection<String> destination = new ArrayList<>();

        blockingQueue.drainTo(destination);

        // drains up to 5 elements. If there are less than 5 elements, say there are only 2 elements.
        // Then only 2 elements will drained to the destination.
        blockingQueue.drainTo(destination, 5);
    }
}
