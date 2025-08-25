package org.com.core.manipulations.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Function that takes a string and returns the first non-repeating character.
 *
 * Example: "swiss" → returns 'w'.
 * If no unique character exists, return null.
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String tmpStr = "unique";
        //Character c = nonRepeatingCharacterImperative(tmpStr);
        Character c = nonRepeatingCharacterLambda(tmpStr);

        System.out.println(c != null
                ? c + " is the first non repeating character."
                : "The string " + tmpStr + " doesn't have a non repeating character.");
    }

    /**
     * Imperative solution.
     *
     * @param tmpStr
     * @return
     */
    public static Character nonRepeatingCharacterImperative(String tmpStr) {
        Map<Character, Integer> charCounter = new HashMap<>();
        boolean isFirstNonRepeatingCharacter = false;
        char firstNonRepeatingCharacter = 0;

        for (int i = 0; i < tmpStr.length(); i++) {
            if (charCounter.containsKey(tmpStr.charAt(i))) {
                charCounter.put(tmpStr.charAt(i), charCounter.get(tmpStr.charAt(i)) + 1);
            } else {
                charCounter.put(tmpStr.charAt(i), 1);
            }
        }

        for (int i = 0; i < tmpStr.length(); i++) {
            if (charCounter.get(tmpStr.charAt(i)) == 1) {
                isFirstNonRepeatingCharacter = true;
                firstNonRepeatingCharacter = tmpStr.charAt(i);
                break;
            }
        }

        if (isFirstNonRepeatingCharacter) {
            return firstNonRepeatingCharacter;
        } else {
            return null;
        }
    }

    /**
     * Improved Imperative solution.
     *
     * @param tmpStr
     * @return
     */
    public static Character nonRepeatingCharacterImperative1(String tmpStr) {
        Map<Character, Integer> charCounter = new HashMap<>();

        for (char c : tmpStr.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }

        for (char c : tmpStr.toCharArray()) {
            if (charCounter.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    /**
     * Functional style using Lambda and Stream.
     *
     * @param str
     * @return
     */
    public static Character nonRepeatingCharacterLambda(String str) {
        return str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // to preserve insertion order
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
