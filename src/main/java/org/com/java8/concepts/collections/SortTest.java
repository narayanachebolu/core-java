package org.com.java8.concepts.collections;

import org.com.java8.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student(1, "yashu");
        Student student2 = new Student(8, "sarika");
        Student student3 = new Student(3, "teju");
        Student student4 = new Student(6, "anshu");
        Student student5 = new Student(5, "devyan");
        Student student6 = new Student(4, "nakshu");
        Student student7 = new Student(7, "sai");
        Student student8 = new Student(2, "yarya");
        Student student9 = new Student(2, "karya");
        Student student10 = new Student(2, "narya");

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);

        System.out.println(studentList);

        //Collections.sort(studentList);
        studentList.sort(new IdComparator());
        System.out.println(studentList);

        studentList.sort(new NameComparator());
        System.out.println(studentList);

    }
}
