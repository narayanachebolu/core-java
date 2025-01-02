package org.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindStringMethods {
    public static void main(String[] args) {
        List<String> stringArray = Arrays.asList(
                "Stream operations are divided into intermediate and terminal operations, and are combined to form stream pipelines",
                "This behavior becomes even more important when the input stream is infinite and not merely large.",
                "Stateful operations may need to process the entire input before producing a result.",
                "Terminal operations, such as Stream. forEach or IntStream. sum, may traverse the stream to produce a result or a side-effect.");
        int nCharLen = 100;

        Optional<String> firstString = firstStringLongerThan(stringArray, nCharLen);
        firstString.ifPresentOrElse(
                str -> System.out.println("First string longer than " + nCharLen + " characters: " + str),
                () -> System.out.println("No string found with length: " + nCharLen)
        );
    }

    private static Optional<String> firstStringLongerThan(List<String> stringArray, int number) {
        return stringArray.stream()
                .filter(str -> str.length() > number)
                .findFirst();
    }
}
