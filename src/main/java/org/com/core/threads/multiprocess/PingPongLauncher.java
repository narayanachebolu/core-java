package org.com.core.threads.multiprocess;

import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class PingPongLauncher {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        String javaCmd = "java";
        // get the classpath of the running jar.
        // This way, whether you run from classes or from a JAR, the child processes will get the correct classpath.
        String classPath = new File(PingPongLauncher.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI()
        ).getPath();

        // Fully qualified class names
        String serverClass = "org.com.core.threads.multiprocess.PingPongServer";
        String clientClass = "org.com.core.threads.multiprocess.PingPongClient";

        // server process
        ProcessBuilder serverProcessBuilder = new ProcessBuilder(javaCmd, "-cp", classPath, serverClass);
        serverProcessBuilder.redirectErrorStream(true);
        Process serverProcess = serverProcessBuilder.start();

        // client process
        ProcessBuilder clientProcessBuilder = new ProcessBuilder(javaCmd, "-cp", classPath, clientClass);
        clientProcessBuilder.redirectErrorStream(true);
        Process clientProcess = clientProcessBuilder.start();

        // pipe server output
        new Thread(() -> pipeOutput("SERVER", serverProcess.getInputStream())).start();
        // pipe client output
        new Thread(() -> pipeOutput("CLIENT", clientProcess.getInputStream())).start();

        // wait for processes to finish
        int exitServer = serverProcess.waitFor();
        int exitClient = clientProcess.waitFor();

        System.out.println("Server exited with code: " + exitServer);
        System.out.println("Server exited with code: " + exitClient);
    }

    private static void pipeOutput(String tag, InputStream inputStream) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("[" + tag + "]" + line);
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
}
