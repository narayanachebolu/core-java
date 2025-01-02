package org.com.java8.concepts.oop;

public class StringObject {

    public static void main(String[] args) {
        // Two objects are created using the new keyword + string literal.
        // 1. object is created with new keyword in heap area
        // 2. another object is created with string literal in SCP (String Constant Pool) area
        String string1 = new String("Java Addict");

        // If it same string as string literal above, then it doesn't create a new object.
        // It rather uses the same string from SCP area.
        String string2 = "Java Addict";

        // prove
        System.out.println(string1.intern());
        //System.out.println(string1.intern().equals(string2));
        System.out.println(string1.intern().hashCode() == string2.hashCode());
    }
}
