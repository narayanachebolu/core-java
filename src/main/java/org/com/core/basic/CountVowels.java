package org.com.core.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountVowels {
    public static void main(String[] args) {
        String str = "Functional Programming with Java Streams";
        System.out.println("Vowels in a given string are " + countVowels(str));

        System.out.println("Count by each vowel: " + countByVowels(str));
    }

    private static long countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        return str.toLowerCase().chars() // returns Intstream of chars
                .mapToObj(c -> (char)c) // convert integer to char
                .filter(vowels::contains) // keep only vowels
                .count(); // count vowels
    }

    private static Map<Character, Long> countByVowels(String str) {
        if (str == null || str.isEmpty()) {
            return new HashMap<>();
        }

        return str.toLowerCase()
                .chars()
                .mapToObj(c -> (char)c)
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
