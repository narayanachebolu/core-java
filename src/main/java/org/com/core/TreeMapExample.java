package org.com.core;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>(); // sorts based on key

        map.put("a", "apple");
        map.put("e", "egg");
        map.put("b", "banana");
        map.put("c", "cherry");
        map.put("o", "orange");

        // "e".compareTo("a")
        // < ---> inserts left side (returns -1)
        // > ---> inserts right side (returns +1)
        // "a", "e"
        // "b".compareTo("e")
        // "a", "b", "e"
        // "c".compareTo("b")
        // "a", "b", "c", "e"
        // "o".compareTo("c")
        // "o".compareTo("e")
        // "a", "b", "c", "e", "o"

        System.out.println(map);

    }
}
