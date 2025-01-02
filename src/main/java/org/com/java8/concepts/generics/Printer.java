package org.com.java8.concepts.generics;

public class Printer <T> {
    private T printThis;

    public Printer(T printThis) {
        this.printThis = printThis;
    }

    public void print() {
        System.out.println(printThis);
    }
}
