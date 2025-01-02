package org.com.java8.concepts.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastMap {
    /**
     * Fail Fast Iterator: A iterator which will fail when the collection object is being modified while iterating
     * through the collection.
     *
     * Fail Safe Iterator: A iterator which will allow modifications without failing while iterating through the
     * collection is called fail safe iterator. It is achieved by using classes in java.util.concurrent package.
     */
    public static void main(String[] args) {
        // Map<Integer, String> stringMap = new HashMap<>();
        // in order to overcome ConcurrentModificationException, use ConcurrentHashMap.
        Map<Integer, String> stringMap = new ConcurrentHashMap<>();
        stringMap.put(1, "naren");
        stringMap.put(2, "kala");

        Iterator<Integer> iterator = stringMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer nextKey = iterator.next();
            System.out.println(nextKey + " -> " + stringMap.get(nextKey));
            stringMap.put(3, "yashu");
        }
    }
}
