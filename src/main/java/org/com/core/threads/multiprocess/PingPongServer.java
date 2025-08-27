package org.com.core.threads.multiprocess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {
    public static void main(String[] args) throws Exception {
        int limit = 10;
        int port = 5000;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server waiting on port: " + port);

        try (Socket socket = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
            for (int i = 1; i <= limit; i++) {
                // server sends message first
                String msg = "Message from process (server): " + i;
                System.out.println(msg);
                printWriter.println(msg);

                // wait for response
                String response = bufferedReader.readLine();
                System.out.println("Received message: " + response);
            }
        }
    }
}
