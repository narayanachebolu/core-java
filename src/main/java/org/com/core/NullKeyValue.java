package org.com.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NullKeyValue {
    public static void main(String[] args) {
        //Map<String, String> map = new HashMap<>();   // non-synchronized
        Map<String, String> map = new ConcurrentHashMap<>(); // synchronized
        map.put(null, null);
        System.out.println(map);
    }
}
