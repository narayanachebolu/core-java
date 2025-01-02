package org.com.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement: Create a custom functional interface StringTransformer with a method that takes a
 * string and returns a string. Implement it with a method reference to a static method that reverses
 * the string. Apply this transformation to a list of strings.
 */
@FunctionalInterface
interface StringTransformer {
    String transform(String str);
}
public class CustomFunctionalInterface {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "pineapple", "grapes", "banana", "honey");
        StringTransformer stringTransformer = CustomFunctionalInterface::stringReverse;

        words.stream()
                .map(stringTransformer::transform)
                .toList()
                .forEach(System.out::println);
    }

    public static String stringReverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
}


