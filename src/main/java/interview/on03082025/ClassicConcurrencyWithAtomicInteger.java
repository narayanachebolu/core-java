package interview.on03082025;

import java.util.concurrent.atomic.AtomicInteger;

public class ClassicConcurrencyWithAtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerCounter atomicIntegerCounter = new AtomicIntegerCounter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicIntegerCounter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Expected: 3000.");
        System.out.println("Actual: " + atomicIntegerCounter.getCount());
    }
}


class AtomicIntegerCounter {
    private final AtomicInteger atomicIntegerCounter = new AtomicInteger(0);

    public void increment() {
        atomicIntegerCounter.incrementAndGet();
    }

    public int getCount() {
        return atomicIntegerCounter.get();
    }
}
