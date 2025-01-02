package org.com.java8.concepts.generics;

import org.com.java8.entity.Animal;
import org.com.java8.entity.Cat;
import org.com.java8.entity.Cow;
import org.com.java8.entity.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenerics {

    public static void main(String[] args) {
        AnimalPrinter<Cow> cowAnimalPrinter = new AnimalPrinter<>(new Cow());
        cowAnimalPrinter.sound();

        AnimalPrinter<Dog> dogAnimalPrinter = new AnimalPrinter<>(new Dog());
        dogAnimalPrinter.sound();

        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>(new Cat());
        catAnimalPrinter.sound();

        Printer<Integer> integerPrinter = new Printer<>(111);
        integerPrinter.print();

        Printer<String> stringPrinter = new Printer<>("Hello generics..");
        stringPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(12.34);
        doublePrinter.print();

        TestGenerics testGenerics = new TestGenerics();
        testGenerics.genericBoundedMethod(new Cat());
        testGenerics.genericBoundedMethod(new Dog());
        testGenerics.genericBoundedMethod(new Cow());

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(11, 22, 33, 44, 55));
        printList(integerArrayList);

        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
        printList(stringArrayList);

        // since java 10, there is some thing called local variable type inference.
        // Meaning, the type of the variable can be replaced with var
        // Example: SimpleCalculator simpleCalc = new SimpleCalculator(); can be replaced with
        // var simpleCalc = new SimpleCalculator();
        // ArrayList<Cat> catArrayList = new ArrayList<>();
        var catArrayList = new ArrayList<Cat>();
        catArrayList.add(new Cat());
        catArrayList.add(new Cat());
        catArrayList.add(new Cat());
        printAnimalList(catArrayList);
    }

    public <T> void genericMethod(T printThis) {
        System.out.println(printThis);
    }

    public <T extends Animal> void genericBoundedMethod(T iamAnimalType) {
        iamAnimalType.eat();
    }

    public static void printList(List<?> myList) { // wildcard generics
        System.out.println(myList);
    }

    public static void printAnimalList(List<? extends Animal> myAnimalList) { // bounded wildcard generics
        System.out.println("I am having " + myAnimalList.size() + " " + myAnimalList.getClass().toString());
    }
}
