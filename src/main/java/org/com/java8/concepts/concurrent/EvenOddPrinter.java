package org.com.java8.concepts.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {
    private static final Object lock = new Object();
    private static final IntPredicate evenPredicate = n -> n % 2 == 0;
    private static final IntPredicate oddPredicate = n -> n % 2 != 0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddPrinter.print(evenPredicate));
        CompletableFuture.runAsync(() -> EvenOddPrinter.print(oddPredicate));

        Thread.sleep(1000);
    }

    private static void print(IntPredicate condition) {
        IntStream
                .rangeClosed(1, 10)
                .filter(condition)
                .forEach(EvenOddPrinter::execute);
    }

    private static void execute(int num) {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " - " + num);
                lock.notify();
                lock.wait();
            } catch (InterruptedException ix) {
                ix.printStackTrace();
            }
        }
    }
}
