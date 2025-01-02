package org.com.java8.concepts.collections;

import org.com.java8.entity.Student;

import java.util.Comparator;

public class IdComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        //return Integer.compare(o1.getId(), o2.getId());
        
        // sort by id and then by name:
        // if two or more ids are same, then sort by name.
        int output = 0;
        if (o1.getId() == o2.getId()) {
            output =  o1.getName().compareTo(o2.getName());
        } else if (o1.getId() > o2.getId()) {
            output =  1;
        } else if (o1.getId() < o2.getId()) {
            output =  -1;
        }
        return output;
    }
}
