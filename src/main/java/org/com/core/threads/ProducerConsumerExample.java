package org.com.core.threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    int capacity;
    Queue<Integer> queue = new LinkedList<>();

    public ProducerConsumerExample(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        ProducerConsumerExample producerConsumerExample = new ProducerConsumerExample(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    producerConsumerExample.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException ix) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    producerConsumerExample.consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException ix) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    public synchronized void produce(int value) throws InterruptedException {
        if (queue.size() == capacity) {
            wait(); // queue is full. wait until a space is available.
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        if (queue.isEmpty()) {
            wait(); // queue is empty, wait until a value is available to consume.
        }
        System.out.println("Consumed: " + queue.poll());
        notifyAll();
    }
}
