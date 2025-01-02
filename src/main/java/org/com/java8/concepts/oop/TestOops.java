package org.com.java8.concepts.oop;

import org.com.java8.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class TestOops {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.staticMethod();

        Child child = new Child();
        child.staticMethod();

        Parent.staticMethod();
        Child.staticMethod();

        FinalizeDemo finalizeDemo = new FinalizeDemo();
        finalizeDemo = null;
        System.gc();

        Employee employee1 = new Employee(1, "Lakshmi", "it");
        Employee employee2 = new Employee(1, "Lakshmi", "pm");

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);

        System.out.println(employeeSet);
    }
}
