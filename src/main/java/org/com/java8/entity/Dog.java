package org.com.java8.entity;

public class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("bow bow..");
    }

    @Override
    public void eat() {
        System.out.println("I eat egg.");
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
