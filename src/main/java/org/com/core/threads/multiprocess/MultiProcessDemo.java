package org.com.core.threads.multiprocess;

public class MultiProcessDemo {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 3; i++) {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "Worker", String.valueOf(i));

            processBuilder.inheritIO(); // attach STDIO / STDERR to current console.
            Process process = processBuilder.start();
            System.out.println("Started Worker-" + i + " with PID: " + process.pid());
        }
    }
}
