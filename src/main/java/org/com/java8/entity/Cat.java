package org.com.java8.entity;

public class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("meom..");
    }

    @Override
    public void eat() {
        System.out.println("I eat rat..");
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
