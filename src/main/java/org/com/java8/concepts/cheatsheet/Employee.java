package org.com.java8.concepts.cheatsheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private List<Project> projects;
    private double salary;
    private String gender;

    public <T> Employee(int i, String johnDoe, String development, List<T> list, int i1, String male) {
    }
}
