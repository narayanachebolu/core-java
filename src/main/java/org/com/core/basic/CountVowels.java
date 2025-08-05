package org.com.core.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class CountVowels {
    public static void main(String[] args) {
        String str = "Count vowels in a given string.";
        System.out.println("Vowels in a given string are " + countVowels(str));
    }

    private static long countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        return str.toLowerCase().chars()
                .mapToObj(c -> (char)c)
                .filter(vowels::contains)
                .count();
    }
}
