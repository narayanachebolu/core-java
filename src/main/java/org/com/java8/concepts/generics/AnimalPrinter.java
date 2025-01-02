package org.com.java8.concepts.generics;

import org.com.java8.entity.Animal;

public class AnimalPrinter <T extends Animal> { // bounded generics
    T animalPrinter;

    public AnimalPrinter(T animalPrinter) {
        this.animalPrinter = animalPrinter;
    }

    public void sound() {
        animalPrinter.makeSound();
    }

    public void eat() {
        animalPrinter.eat();
    }
}
