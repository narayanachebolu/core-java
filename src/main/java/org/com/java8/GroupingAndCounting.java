package org.com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem Statement: Given a list of strings representing words, group the words by their length and
 * count the number of words of each length.
 */

public class GroupingAndCounting {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lime");

        words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                .forEach((length, count) -> System.out.println("Length: " + length + " Count: " + count));
    }
}
