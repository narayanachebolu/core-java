package org.com.java8.challenges.simple;

import java.util.List;
import java.util.Optional;

public class Student {
    private String name;
    private int id;
    private List<Integer> grades;

    public Student() {
    }

    public Student(String name, int id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        return grades.isEmpty() ? 0 :
                grades.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", grades=" + grades +
                '}';
    }
}
