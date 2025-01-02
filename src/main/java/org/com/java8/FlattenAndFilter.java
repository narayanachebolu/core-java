package org.com.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement: Given a list of lists of integers, flatten the lists into a single list and
 * filter out any numbers less than 5. Sort the resulting list in descending order.
 */
public class FlattenAndFilter {

    public static void main(String[] args) {
        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(3, 5, 8, 13)
        );

        nestedLists
                .stream()
                .flatMap(List::stream)
                .filter(number -> number >= 5)
                .sorted((a, b) -> b - a)
                .toList()
                .forEach(System.out::println);
    }
}
