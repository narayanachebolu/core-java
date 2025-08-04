package org.com.core.basic;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReverse {
    public static void main(String[] args) {
        String str = "HowAreYou?";

        System.out.println(conventionalWay(str));

        System.out.println("Using java streams: " + strReverse(str));

        System.out.println("Using StringBuilder and Lambdas: " + usingStringBuilder(str));
    }

    private static String conventionalWay(String str) {
        StringBuilder rev = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }

        return rev.toString();
    }

    private static String strReverse(String str) {
        StringBuilder rev = new StringBuilder();
        return IntStream
                .rangeClosed(1, str.length())
                .mapToObj(i -> str.charAt(str.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static String usingStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
