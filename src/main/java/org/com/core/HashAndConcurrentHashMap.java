package org.com.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class HashAndConcurrentHashMap extends Thread {
    //private static Map<Integer, String> map = new HashMap<>();
    private static Map<Integer, String> map = new ConcurrentHashMap<>();

    public void run() {
        try {
            Thread.sleep(1000);
            // child thread trying to add a new element.
            map.put(111, "apple");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        map.put(101, "orange");
        map.put(102, "banana");
        map.put(103, "peers");
        map.put(105, "kiwi");

        HashAndConcurrentHashMap customThread = new HashAndConcurrentHashMap();
        customThread.start();

        // main thread iterating the map
        for(Object o : map.entrySet()) {
            System.out.println(o);
            Thread.sleep(1000);
        }

        System.out.println(map);

        // segment locking or bucket locking
    }
}
