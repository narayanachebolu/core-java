package org.com.java8.concepts.collections;

import org.com.java8.entity.Student;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.compareTo(o2);
    }
}
