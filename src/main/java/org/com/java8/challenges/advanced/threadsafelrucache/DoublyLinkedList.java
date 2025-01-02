package org.com.java8.challenges.advanced.threadsafelrucache;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    DoublyLinkedList() {
        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.previous = head;
    }

    void addFirst(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    void moveToFront(Node node) {
        remove(node);
        addFirst(node);
    }

    Node removeLast() {
        if (tail.previous == head) {
            return null;
        }
        Node node = tail.previous;
        remove(node);
        return node;
    }

    void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}
