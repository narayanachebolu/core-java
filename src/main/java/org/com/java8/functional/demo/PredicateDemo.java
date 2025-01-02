package org.com.java8.functional.demo;

import java.util.Arrays;
import java.util.List;

public class PredicateDemo {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        integerList
                .stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }
}
