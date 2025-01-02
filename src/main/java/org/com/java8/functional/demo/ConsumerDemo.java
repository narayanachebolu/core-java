package org.com.java8.functional.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = number -> System.out.println("Printing: " + number);
        integerConsumer.accept(111);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        integerList.forEach(System.out::println);
    }
}
