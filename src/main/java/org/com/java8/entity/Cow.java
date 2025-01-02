package org.com.java8.entity;

public class Cow implements Animal {
    @Override
    public void makeSound() {
        System.out.println("amba..");
    }

    @Override
    public void eat() {
        System.out.println("I eat grass.");
    }

    @Override
    public String toString() {
        return "Cow";
    }
}
