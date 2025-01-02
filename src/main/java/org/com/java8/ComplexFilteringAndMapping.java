package org.com.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement: Given a list of Person objects with attributes name, age, and salary, perform the following tasks:
 *
 * 1) Filter the list to include only persons who are older than 30 and have a salary greater than 50,000.
 * 2) Sort the filtered list by name in ascending order.
 * 3) Create a new list of strings where each string is in the format: "Name: [name], Age: [age], Salary: [salary]".
 * 4_ Print the resulting list.
 */

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class ComplexFilteringAndMapping {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 35, 60000));
        persons.add(new Person("Alice", 28, 75000));
        persons.add(new Person("Bob", 40, 50000));
        persons.add(new Person("Jane", 32, 55000));
        persons.add(new Person("Mark", 30, 45000));

        persons.stream()
                .filter(person -> person.getAge() > 30 && person.getSalary() > 50000) // predicate
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .map(person -> "Name: " + person.getName() + ", Age: " + person.getAge() + ", Salary: " + person.getSalary())
                .toList()
                .forEach(System.out::println);  // consumer
    }
}
