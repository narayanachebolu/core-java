package org.com.core.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Group people by age from a list of Person objects.
 */
public class GroupPeople {
    public static void main(String[] args) {
        People people1 = new People("ABC", 11, "Frankfurt", 10);
        People people2 = new People("BCD", 21, "Hamburg", 20);
        People people3 = new People("CDE", 31, "Berlin", 10);
        People people4 = new People("DEF", 41, "Munich", 30);
        People people5 = new People("EFG", 14, "Nürnberg", 30);

        List<People> peopleList = Arrays.asList(people1, people2, people3, people4);
        System.out.println("People count grouped by age range: " + groupPeopleByAgeRange(peopleList));

        System.out.println("People by department: " + groupPeopleByDept(peopleList));
        System.out.println("People count by department: " + peopleCountByDept(peopleList));
    }

    private static Map<Integer, List<People>> groupPeopleByAgeRange(List<People> peopleList) {
        return peopleList
                .stream()
                .collect(Collectors.groupingBy(People::age));
    }

    private static Map<Integer, List<People>> groupPeopleByDept(List<People> peopleList) {
        return peopleList
                .stream()
                .collect(Collectors.groupingBy(People::department));
    }

    private static Map<Integer, Long> peopleCountByDept(List<People> peopleList) {
        return peopleList
                .stream()
                .collect(Collectors.groupingBy(People::department, Collectors.counting()));
    }
}