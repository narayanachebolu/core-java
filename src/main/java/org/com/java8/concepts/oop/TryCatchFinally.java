package org.com.java8.concepts.oop;

public class TryCatchFinally {
    public static int testFinally() {
        try {
            //int i = 10 / 0;
            //System.exit(0);
            return 1;
        } catch (Exception x) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(testFinally());
    }
}
