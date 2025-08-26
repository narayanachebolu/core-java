package org.com.core.threads;

public class PingPong {

    public static void main(String[] args) {
        Object OBJECT_LOCK = new Object();

        Thread pingThread = new Thread(new PingPongThread(OBJECT_LOCK, "ping"));
        Thread pongThread = new Thread(new PingPongThread(OBJECT_LOCK, "pong"));

        pingThread.start();
        pongThread.start();
    }
}

class PingPongThread implements Runnable {
    private final Object OBJECT_LOCK;
    private final String name;

    public PingPongThread(Object OBJECT_LOCK, String name) {
        this.OBJECT_LOCK = OBJECT_LOCK;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (OBJECT_LOCK) {
            while (true) {
                System.out.println(name);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ix) {
                    ix.printStackTrace();
                }

                OBJECT_LOCK.notify();

                try {
                    OBJECT_LOCK.wait(1000);
                } catch (InterruptedException ix) {
                    ix.printStackTrace();
                }
            }
        }
    }
}