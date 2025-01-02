package org.com.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class SortString {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ajay");
        names.add("Kari");
        names.add("Kalyan");
        names.add("Soni");
        names.add("Badi");
        names.add("Rupa");

        // alphabetical order
        names.sort((a, b) -> a.compareTo(b));

        // reverse order
        names.sort((a, b) -> b.compareTo(a));

        //names.sort(String::compareTo);

        names.forEach(System.out::println);
    }
}
