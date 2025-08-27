package org.com.core.threads.multiprocess;

public class Worker {
    public static void main(String[] args) {
        String id = args[0];
        long processId = ProcessHandle.current().pid();
        System.out.println("Worked " + id + " running in PID: " + processId);
    }
}
