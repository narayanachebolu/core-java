package org.com.java8.challenges.advanced.threadsafelrucache;

public class Node <K, V> {
    K key;
    V value;
    Node<K, V> next;
    Node<K, V> previous;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
