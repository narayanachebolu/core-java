package org.com.java8.challenges.advanced.threadsafelrucache;

import java.util.HashMap;
import java.util.Map;

// Last Recently Used (LRU) cache
public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> cache;
    private final DoublyLinkedList linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }

    public synchronized V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        linkedList.moveToFront(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
            node.value = value;
            linkedList.moveToFront(node);
        } else {
            if (cache.size() >= capacity) {
                Node<K, V> lru = linkedList.removeLast();
                cache.remove(lru.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
            linkedList.addFirst(newNode);
            cache.put(key, newNode);
        }
    }
}
