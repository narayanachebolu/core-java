package org.com.java8.challenges.beginner;

import javax.swing.plaf.TableHeaderUI;

public class EvenOddThreadsJava7Style implements Runnable{
    static int count = 0;
    Object object;

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new EvenOddThreadsJava7Style(lock);
        Runnable r2 = new EvenOddThreadsJava7Style(lock);

        new Thread(r1, "even").start();
        new Thread(r2, "odd").start();
    }

    public EvenOddThreadsJava7Style(Object object) {
        this.object = object;
    }

    @Override
    public void run() { // print even and odd number in synchronized manner.
        while(count <= 10) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println("Thread name: " + Thread.currentThread().getName() + ". Value: " + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println("Thread name: " + Thread.currentThread().getName() + ". Value: " + count);
                    count++;
                    object.notify();
                }
            }
        }
    }
}
