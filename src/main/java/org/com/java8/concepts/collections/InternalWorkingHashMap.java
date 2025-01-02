package org.com.java8.concepts.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InternalWorkingHashMap extends Thread {
    //static Map<Integer, String> integerStringMap = new HashMap<>();
    static Map<Integer, String> integerStringMap = new ConcurrentHashMap<>();

    public void run() {
        try {
            Thread.sleep(1000);
            integerStringMap.put(5, "naren");
        } catch (InterruptedException ix) {
            System.out.println("Child thread is adding element.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InternalWorkingHashMap internalWorkingHashMap = new InternalWorkingHashMap();
        integerStringMap.put(4, "amma");
        integerStringMap.put(1, "kala");
        integerStringMap.put(2, "yashu");
        integerStringMap.put(3, "teju");

        internalWorkingHashMap.start();

        for (Object object : integerStringMap.entrySet()) {
            System.out.println(object);
            Thread.sleep(1000);
        }

        System.out.println(integerStringMap);
    }
}
