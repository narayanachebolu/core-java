package org.com.java8.challenges.simple;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDigitsFromStringTest {
    static final String INPUT_STRING = "M3a9n2y n8u6m7b5e4r0s1";
    static final String EXPECTED_STRING = "Many numbers";
    static final String DIGIT_REGEX = "\\d";

    @Test
    void whenUsingReplaceAll_thenGetExpectedString() {
        var actualResult = INPUT_STRING.replaceAll(DIGIT_REGEX, "");
        assertEquals(EXPECTED_STRING, actualResult);
    }

    @Test
    void whenUsingPatternAndMatcher_thenGetExpectedString() {
        var regexPattern = Pattern.compile(DIGIT_REGEX);
        var regexMatcher = regexPattern.matcher(INPUT_STRING);
        var actualString = regexMatcher.replaceAll("");

        assertEquals(EXPECTED_STRING, actualString);
    }

    @Test
    void whenUsingForLoop_thenGetExpectedString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : INPUT_STRING.toCharArray()) {
            if (!Character.isDigit(ch)) {
                stringBuilder.append(ch);
            }
        }

        assertEquals(EXPECTED_STRING, stringBuilder.toString());
    }

    @Test
    void whenUsingCharacterStream_theGetExpectedString() {   // understand it and practice more of its kind.
        String updatedString = INPUT_STRING.chars()
                .filter(ch -> !Character.isDigit(ch))
                .mapToObj(ch -> (char) ch)
                .map(String::valueOf)
                .collect(Collectors.joining());

        assertEquals(EXPECTED_STRING, updatedString);
    }
}
