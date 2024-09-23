package org.example;

public class Deque {

    Node head;
    Node tail;

    public Deque() {
        head = null;
        tail = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("Deque is empty!");
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    }

    public void removeLast() {
        if (tail == null) {
            throw new RuntimeException("Deque is empty!");
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
    }

    public int peekFirst() {
        if (head == null) {
            throw new RuntimeException("Deque is empty!");
        }
        return head.data;
    }

    public int peekLast() {
        if (tail == null) {
            throw new RuntimeException("Deque is empty!");
        }
        return tail.data;
    }

    public boolean isDequeEmpty() {
        return head == null;
    }

    public void printDeque() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println("Node data is : " + currentNode.data + "\n");
            currentNode = currentNode.next;
        }
    }

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

}
