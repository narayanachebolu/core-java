package org.com.core.basic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenLists {
    public static void main(String[] args) {
        List<List<Integer>> integerList = Arrays.asList(Arrays.asList(1, 3, 5, 7, 9), Arrays.asList(0, 2, 4, 6, 8), Arrays.asList(-1, -3, -5, -7, -9), Arrays.asList(-2, -4, -6, -8));

        List<Integer> list = integerList
                .stream()
                .flatMap(Collection::stream)
                .toList();

        System.out.println(list);
    }
}
