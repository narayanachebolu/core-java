package org.com.java8.challenges.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("Student Management System:");
            System.out.println("1. Add a new student");
            System.out.println("2. Record a grade for a student");
            System.out.println("3. Calculate and display average grade of a student");
            System.out.println("4. Display all students and their grades");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    recordGrade(scanner);
                    break;
                case 3:
                    calculateAndDisplayAverage(scanner);
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        Student student = new Student(name, nextId++);
        students.add(student);
        System.out.println("Student added: " + student);
    }

    private static void recordGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            student.addGrade(grade);
            System.out.println("Grade added for student " + student.getName());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void calculateAndDisplayAverage(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);
        if (student != null) {
            double average = student.calculateAverage();
            System.out.println("Average grade for student " + student.getName() + ": " + average);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
