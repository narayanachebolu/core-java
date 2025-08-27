package org.com.core.threads.multiprocess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PingPongClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 5000;
        int limit = 10;

        try (Socket socket = new Socket(host, port);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
            for (int i = 1; i <= 10; i++) {
                // wait for server message
                String message = bufferedReader.readLine();
                System.out.println("Received message: " + message);

                // reply to process (server)
                String response = "Message from process (client): " + i;
                System.out.println(response);
                printWriter.println(response);
            }
        }
    }
}
