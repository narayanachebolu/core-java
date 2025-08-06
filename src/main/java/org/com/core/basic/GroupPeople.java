package org.com.core.basic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Group people by age from a list of Person objects.
 */
public class GroupPeople {
    public static void main(String[] args) {
        List<People> peopleList = List.of(
                new People("Alice", 10, "Berlin", 1),
                new People("Bob", 15, "Hamburg", 2),
                new People("Charlie", 25, "Munich", 3),
                new People("David", 65, "Cologne", 4),
                new People("Eva", 17, "Stuttgart", 5),
                new People("Frank", 3, "Frankfurt", 6),
                new People("Anna", 25, "Bonn", 7),
                new People("Zane", 18, "Leipzig", 8)
        );

        groupPeopleByAgeRange(peopleList)
                .forEach((group, people) -> {
                    System.out.println(group + ": ");
                    people.forEach(System.out::println);
                    System.out.println();
                });

        System.out.println("People by department: " + groupPeopleByDept(peopleList));
        System.out.println("People count by department: " + peopleCountByDept(peopleList));

        System.out.println("People grouping by age range and then sort each group by name: " +
                groupSortPeopleByAgeGroupAndName(peopleList));
    }

    private static Map<String, List<People>> groupPeopleByAgeRange(List<People> peopleList) {
        return peopleList
                .stream()
                .collect(Collectors.groupingBy(GroupPeople::getAgeGroupLabel));
    }

    private static String getAgeGroupLabel(People people) {
        if (people == null) return "";

        int age = people.age();
        if (age >= 1 && age <= 12) {
            return "Group 1 (1-12)";
        } else if (age >= 13 && age <= 18) {
            return "Group 2 (13-18)";
        } else if (age >= 19 && age <= 59) {
            return "Group 3 (19-59)";
        } else {
            return "Group 4 (60+)";
        }
    }

    private static Map<AgeGroup, List<People>> groupSortPeopleByAgeGroupAndName(List<People> peopleList) {
        return peopleList
                .stream()
                .collect(Collectors.groupingBy(GroupPeople::getAgeGroupLabelFromEnum,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparing(People::name)).toList())));
    }

    private static AgeGroup getAgeGroupLabelFromEnum(People people) {

        int age = people.age();
        if (age >= 1 && age <= 12) {
            return AgeGroup.CHILDREN;
        } else if (age >= 13 && age <= 18) {
            return AgeGroup.TEENAGERS;
        } else if (age >= 19 && age <= 59) {
            return AgeGroup.ADULTS;
        } else {
            return AgeGroup.SENIORS;
        }
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