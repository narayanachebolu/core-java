package org.com.core.threads;

public class JVMShutdownHooks {
    static class Message extends Thread {
        public void run() {
            System.out.println("Thank you!! Bye!!!");
        }
    }

    public static void main(String[] args) {
        try {
            Message message = new Message();

            // registering the message object as shutdown hook.
            Runtime.getRuntime().addShutdownHook(message);

            System.out.println("The program is beginning..");

            System.out.println("Wait for 2 seconds..");
            Thread.sleep(2000);

            Runtime.getRuntime().removeShutdownHook(message);
            System.out.println("The program is terminating..");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
