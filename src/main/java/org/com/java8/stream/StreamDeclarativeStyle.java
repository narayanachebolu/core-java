package org.com.java8.stream;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class StreamDeclarativeStyle {
    static List<Integer> integerList = Arrays.asList(23, 82, 95, 28, 5, 74, 27, 609, 25, 87, 276, 79);

    public static void main(String[] args) {
        countEvenNumbers();
        countOddNumbers();

        sumAllEvenNumbers();
        sumAllOddNumbers();

        printEvenNumbers();
        printOddNumbers();

        findOutIfAnyNumberIsLessThan10();
        findOutWhetherAllNumbersAreLessThan10();

        printAllSubDirectoryNames();
    }

    private static void countOddNumbers() {
        System.out.println(integerList
                .stream()
                .filter(number -> number % 2 != 0)
                .count());
    }

    public static void countEvenNumbers() {
        long evenCount = integerList.stream()
                .filter(number -> number % 2 == 0)
                .count();
        System.out.println(evenCount);
    }

    public static void sumAllEvenNumbers() {
        System.out.println("Sum of all EVEN numbers: " + integerList
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static void sumAllOddNumbers() {
        System.out.println("Sum of all ODD numbers: " + integerList
                .stream()
                .filter(number -> number % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static void printEvenNumbers() {
        integerList
                .stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    public static void printOddNumbers() {
        integerList
                .stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }

    public static void findOutWhetherAllNumbersAreLessThan10() {
        System.out.println("All numbers in the list are less than 10: " + integerList
                .stream()
                .allMatch(num -> num < 10));
    }

    public static void findOutIfAnyNumberIsLessThan10() {
        System.out.println("List has numbers less than value 10: " + integerList
                .stream()
                .anyMatch(num -> num < 10));
    }

    public static void printAllSubDirectoryNames() {
        System.out.println(Arrays.stream(new File("c:\\").listFiles())
                .filter(File::isDirectory)
                .map(File::getName)
                .toList());
    }
}
