package org.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExample1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11);

        numbers.forEach(number -> System.out.println(number));

        System.out.println("------------------------------------");

        // using method reference
        numbers.forEach(System.out::println);

        System.out.println("------------------------------------");

        // Instance method of an Arbitrary object of a Particular type
        List<String> items = Arrays.asList("pen", "paper", "book", "watch", "bottle", "ink", "tablet");

        items.sort(String::compareToIgnoreCase);

        items.forEach(System.out::println);

        System.out.println("-------------------------------------");

        items.stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        items.stream()
                .map(String::length)
                .toList()
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        numbers.stream()
                .map(String::valueOf)
                .toList()
                .forEach(System.out::println);
    }
}
