package org.com.java8.challenges.moderate;

import java.util.*;
import java.util.stream.Collectors;

public class NthHighestNumber {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(23, 58, 109, 85, 200, 482, 852, 928, 750, 843, 924, 759, 842);
        // what all can I do with an int stream?
        // 1. sort

        System.out.println(nthHighestNumber(2, integerList));


        Map<String, Integer> integerMap = new HashMap<>();
        integerMap.put("A", 98231);
        integerMap.put("B", 20397);
        integerMap.put("C", 75921);
        integerMap.put("D", 39132);
        integerMap.put("E", 10954);
        integerMap.put("F", 58286);
        integerMap.put("G", 89242);
        integerMap.put("H", 40984);
        integerMap.put("I", 29834);
        integerMap.put("J", 64921);
        integerMap.put("K", 87593);
        integerMap.put("L", 75921);
        integerMap.put("M", 10954);
        integerMap.put("N", 20397);
        integerMap.put("O", 29834);
        integerMap.put("P", 98231);
        integerMap.put("Q", 87593);
        integerMap.put("R", 20397);
        integerMap.put("S", 98231);
        integerMap.put("T", 89242);
        integerMap.put("U", 87593);
        integerMap.put("V", 98231);

        System.out.println(nthHighestSalary(3, integerMap));

        // how to access memory dump.
        // how to print string constant pool
        // practice unmodifiable List, Set, Map
        // List (LinkedList, ArrayList), Set (HashSet, LinkedHashSet TreeSet), Map (HashMap, TreeMap), concurrent package4

    }

    public static int nthHighestNumber(int nthPosition, List<Integer> intList) {
        return intList.stream().sorted(Collections.reverseOrder()).toList().get(nthPosition-1);
    }

    public static Map.Entry<Integer, List<String>> nthHighestSalary(int nThPosition, Map<String, Integer> integerMap) {
        return integerMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(nThPosition - 1);
    }
}
