package org.com.java8.challenges.simple;

public class LogarithmExample {
    public static void main(String[] args) {
        double number = 1001.0;
        // the base-10 logarithm is a mathematical function that finds the power to which 10 has to be raised to equal
        // a given number
        double logValue = Math.log10(number);
        System.out.println("The base-10 logarithm of " + number + " is " + logValue);
    }
}
