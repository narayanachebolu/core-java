package org.com.java8.features;

import org.com.java8.entity.Employee;
import org.com.java8.entity.User;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CodeLambda {
    public static void main(String[] args) {
        Runnable run = () -> System.out.println("run method in Runnable interface.");
        new Thread(run).start();

        // write some brief about the Function, so that it will easy to recap.
        Function<Integer, String> myLambdaFunction = (t) -> "Output: " + t;
        System.out.println(myLambdaFunction.apply(10));

        List<Integer> integerList = Arrays.asList(23, 90, 19, 58, 20, 41, 37, 81, 75, 69);
        Predicate<Integer> integerPredicate = t -> t > 20;

        //Consumer<Integer> integerConsumer = t -> System.out.println(t);
        Consumer<Integer> integerConsumer = System.out::println;

        //Comparator<String> reverseSort4String = (o1, o2) -> o1.compareTo(o2);
        Comparator<String> reverseSort4String = String::compareTo;

        Comparator<Integer> reverseSortComparator = (o1, o2) -> Integer.compare(o2, o1);
        //Comparator<Integer> integerComparator = Integer::compare;  // for default sort order use this comparator

        integerList
                .stream()
                .filter(integerPredicate)
                .sorted(reverseSortComparator)
                .forEach(integerConsumer);


        User user1 = new User(1, "amma", "422", Arrays.asList("abc@example.com", "xyz@example.com"));
        User user2 = new User(2, "naren", "072", Arrays.asList("def@example.com", "uvw@example.com"));
        User user3 = new User(3, "kala", "999", Arrays.asList("ghi@example.com", "rst@example.com"));
        User user4 = new User(4, "yashu", "123", Arrays.asList("jkl@example.com", "pqr@example.com"));
        User user5 = new User(5, "teju", "456", Arrays.asList("mno@example.com", "nop@example.com"));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        List<String> userNameList = users.stream()
                .map(User::getUserName)
                .sorted(reverseSort4String)
                .toList();
        System.out.println(userNameList);

        List<List<String>> userEmailsList = users.stream()
                .map(User::getEmail)
                .toList();
        System.out.println(userEmailsList);

        List<String> userEmails = users.stream()
                .flatMap(user -> user.getEmail().stream())
                .sorted(String::compareTo)
                .toList();
        System.out.println(userEmails);

        // using stream to find frequency of each character in a given string.
        String phrase = "A highly skilled and seasoned senior java software engineer.";
        Map<String, Long> characterCounter = Arrays.stream(phrase.split(""))
                .collect(groupingBy(Function.identity(), counting()));
        System.out.println(characterCounter);

        // assume you have a list of employee in various dept, find the highest paid employee for each dept.
        List<Employee> employeeList = Stream.of(
                new Employee(1, "amma", "home", 10000),
                new Employee(6, "ammamma", "home", 8000),
                new Employee(2, "naren", "it", 100000),
                new Employee(2, "nanna", "it", 99000),
                new Employee(3, "kala", "accounts", 50000),
                new Employee(4, "yashu", "student", 75000),
                new Employee(5, "teju", "student", 90000)
        ).toList();
        // to obtain a Comparator that compares Employee objects by their salary.
        Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);

        // approach 1
        Map<String, Optional<Employee>> employeesMap = employeeList.stream()
                .collect(groupingBy(Employee::getDepartment, reducing(BinaryOperator.maxBy(bySalary))));
        System.out.println(employeesMap);

        // approach 2
        Map<String, Employee> employeeMap = employeeList.stream()
                    .collect(groupingBy(Employee::getDepartment, collectingAndThen(maxBy(bySalary), Optional::get)));
        System.out.println(employeeMap);

        // approach 3
        Map<String, Employee> employeeMap1 = employeeList.stream()
                .collect(toMap(Employee::getDepartment, Function.identity(), BinaryOperator.maxBy(bySalary)));
        System.out.println(employeeMap1);

        // stream and parallel stream
        IntStream
                .rangeClosed(1, 11)
                .forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));

        System.out.println("=============================================================");

        IntStream
                .rangeClosed(1, 11)
                .parallel()
                .forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));

    }
}
