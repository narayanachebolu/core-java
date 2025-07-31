package org.com.interview.on31072025;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args) {
        String s = "madam";
        System.out.println("Is " + s + " Palindrome? " + checkPalindrome(s));
        System.out.println("Is " + s + " Palindrome? " + isPalindrome(s));

        s = "Race car";
        System.out.println("Is " + s + " Palindrome? " + checkPalindrome(s));
        System.out.println("Is " + s + " Palindrome? " + isPalindrome(s));

        // palindrome number
        int num = 343;
        System.out.println("Is " + num + " Palindrome? " + isPalindrome(num));

        num = 122123;
        System.out.println(num + ((num == getReverse(num, 0)) ? " is Palindrome" : " is not Palindrome."));

        s = "radars";
        System.out.println(s + (isPalindromeUsingStreams(s) ?  " is Palindrome." : " is NOT Palindrome."));
    }

    public static Boolean checkPalindrome(String s) {
        // convert the string to lower case and remove and empty spaces
        String cleanedOrgStr = s.toLowerCase().replace(" ", "");
        int orgStrLength = cleanedOrgStr.length();
        StringBuilder reverseStr = new StringBuilder();

        // iterate over each character of the string and create a new string out of it
        for (int c = orgStrLength - 1; c >= 0; c--) {
            reverseStr.append(cleanedOrgStr.charAt(c));
        }

        // now decide by comparing the new string and old string.
        System.out.println(reverseStr.toString() + ".." + cleanedOrgStr);
        return reverseStr.toString().equals(cleanedOrgStr);
    }

    /**
     *
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        String cleanedStr = s.toLowerCase().replace(" ", "");
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left  < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Using iteration.
     *
     * @param num
     * @return
     */
    public static boolean isPalindrome(int num) {
        int r, sum = 0, temp = num;
        while (num > 0) {
            // Extract the digits using the modulo (%)
            r = num % 10; // get reminder

            // Using the formula reverse = reverse * 10 + last digit, we will keep updating the reverse variable.
            sum = (sum * 10) + r;

            // We will shorten the number using the divide
            num = num / 10;
        }

        return temp == sum;
    }

    /**
     * function to reverse a number using recursion.
     *
     * @param num
     * @param rev
     * @return
     */
    public static int getReverse(int num, int rev) {
        if (num == 0) {
            return rev;
        }

        int rem = num % 10;
        rev = rev * 10 + rem;

        return getReverse(num / 10, rev);
    }

    public static boolean isPalindromeUsingStreams(String str) {
        return IntStream.range(0, str.length()/2)
                .allMatch(i -> str.charAt(i) == str.charAt((str.length() - 1) - i));
    }
}
