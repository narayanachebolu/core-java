package org.com.java8.functional.demo;

import java.util.Arrays;
import java.util.List;

public class SupplierDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList();

        System.out.println(stringList.stream().findAny().orElseGet(() -> "Hello.."));
    }
}
