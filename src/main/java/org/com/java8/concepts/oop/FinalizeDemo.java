package org.com.java8.concepts.oop;

public class FinalizeDemo {

    @Override
    public void finalize(){
        System.out.println("I am being removed as I was set to NULL.");
    }
}
