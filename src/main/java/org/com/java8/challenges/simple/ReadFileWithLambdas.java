package org.com.java8.challenges.simple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileWithLambdas {

    public static void main(String[] args) {
        var filePath = "pom.xml";

        try (Stream<String> linesStream = Files.lines(Paths.get(filePath))) {
            linesStream.forEach(System.out::println); // Stream operation: terminal operation
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }
}
