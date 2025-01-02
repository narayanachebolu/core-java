package org.com.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement: Given a list of integers, use parallel streams to filter out even numbers,
 * square the remaining numbers, and find the sum of the squared numbers.
 */
public class ParallelStreamProcessing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        int sumOfSquares = numbers.parallelStream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number)
                .reduce(0, Integer::sum);

        System.out.println("Sum of squares of odd numbers: " + sumOfSquares);
    }
}
