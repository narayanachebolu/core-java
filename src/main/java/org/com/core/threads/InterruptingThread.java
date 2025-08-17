package org.com.core.threads;

public class InterruptingThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("hello from thread " + Thread.currentThread().getName());
            } catch (InterruptedException ix) {
                throw new RuntimeException("Thread " + Thread.currentThread().getName() + " interrupted. "
                        + ix.getMessage());
            }
        });

        t1.start();
        try {
            t1.interrupt();
        } catch (Exception x) {
            System.out.println("Exception in thread main " + x.getMessage());
        }
    }
}
