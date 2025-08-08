package org.com.core.basic;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Reverse {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(-1, 23, 90, -10, 19, 58, 20, -75, 41, 37, -43, 81, -58, 75, 69, -20);
        System.out.println(sortIntegerList(integerList, Optional.of("desc")));
    }

    private static List<Integer> sortIntegerList(List<Integer> integerList, Optional<String> orderType) {
        if (integerList == null || integerList.isEmpty()) {
            return Collections.emptyList();
        }

        Predicate<Integer> negativeIntPredicate = i -> i >= 0;
        Comparator<Integer> sortComparator = null;
        if (orderType.isPresent() && "desc".equalsIgnoreCase(orderType.get())) {
            sortComparator = (o1, o2) -> Integer.compare(o2, o1);
        } else {
            sortComparator = Integer::compare;
        }
        Consumer<Integer> outputConsumer = System.out::println;

        return integerList
                .stream()
                .filter(negativeIntPredicate)
                .sorted(sortComparator)
                .toList();
    }
}
