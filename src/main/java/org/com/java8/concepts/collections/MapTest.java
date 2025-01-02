package org.com.java8.concepts.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("a", "xyz");
        stringMap.put("d", "mno");
        stringMap.put("y", "abc");
        stringMap.put("b", "def");
        stringMap.put("k", "ijk");
        stringMap.put("e", "vwx");

        System.out.println(stringMap);
    }
}
