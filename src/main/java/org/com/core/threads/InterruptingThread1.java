package org.com.core.threads;

public class InterruptingThread1 {
    public static void main(String[] args) {
        Runnable task = () -> {
          for (int i = 0; i < 10; i++) {
              if (Thread.interrupted()) {
                  System.out.println(Thread.currentThread().getName() + " is interruped.");
              } else {
                  System.out.println(Thread.currentThread().getName() + " is printing: " + i);
              }
          }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t1.interrupt();

        t2.start();
    }
}
