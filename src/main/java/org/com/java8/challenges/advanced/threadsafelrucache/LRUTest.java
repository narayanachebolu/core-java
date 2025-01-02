package org.com.java8.challenges.advanced.threadsafelrucache;

// Last Recently Used cache
public class LRUTest {
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        System.out.println("Test 1: " + lruCache.get(1));
        System.out.println("Test 2: " + lruCache.get(2));

        lruCache.put(4, "four");

        System.out.println("Test 3: " + lruCache.get(3));
        System.out.println("Test 4: " + lruCache.get(4));

        lruCache.put(5, "five");

        System.out.println("Test 5: " + lruCache.get(1));
        System.out.println("Test 6: " + lruCache.get(2));
        System.out.println("Test 7: " + lruCache.get(4));
        System.out.println("Test 8: " + lruCache.get(5));

        lruCache.put(2, "updated Two");
        System.out.println("Test 9: " + lruCache.get(2));
    }
}
