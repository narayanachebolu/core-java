package org.com.java8.concepts.collections;

import org.com.java8.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "venkat", "it");
        Employee employee2 = new Employee(1, "venkat", "it");
        Employee employee3 = new Employee(2, "vikram", "pm");

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);
        employeeSet.add(employee3);

        // Equals and Hash method implementation in Entity class should not allow duplicates in Set.
        System.out.println(employeeSet);
    }
}
