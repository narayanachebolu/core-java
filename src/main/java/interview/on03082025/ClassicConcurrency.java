package interview.on03082025;

import lombok.Getter;

public class ClassicConcurrency {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("With synchronization..");
        runTest(true);

        System.out.println("Without synchronization..");
        runTest(false);
    }

    private static void runTest(boolean flag) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                if (flag) {
                    counter.safeIncrement();
                } else {
                    counter.unsafeIncrement();
                }
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

        System.out.println("Expected: 3000");
        System.out.println("Actual: " + counter.getCount());
    }
}

@Getter
class Counter {
    int count = 0;

    public synchronized void safeIncrement() {
        count++;
    }

    public void unsafeIncrement() {
        count++;
    }
}
