package org.com.core.threads;

class DaemonThread extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("Daemon thread.." + this.getName());
        } else {
            System.out.println("User thread.." + this.getName());
        }
    }
}

public class TestDaemonThread {
    public static void main(String[] args) {
        DaemonThread daemonThread1 = new DaemonThread();
        DaemonThread daemonThread2 = new DaemonThread();
        DaemonThread daemonThread3 = new DaemonThread();
        DaemonThread daemonThread4 = new DaemonThread();

        daemonThread1.setName("Daemon Thread 1");
        daemonThread1.setDaemon(true);
        daemonThread1.start();
        daemonThread2.setName("Daemon Thread 2");
        daemonThread2.start();
        daemonThread3.setName("Daemon Thread 3");
        daemonThread3.start();
        daemonThread4.setName("Daemon Thread 4");
        daemonThread4.start();
        // NOTE: If you want to make a user thread as Daemon, it must not be started otherwise it will throw IllegalThreadStateException.
        daemonThread4.setDaemon(true);
    }
}