package com.helping.code;

public class LinkedListNodePrint {

    public static void main(String[] args) {
        printNode(new Node(1, new Node(2, new Node(3, new Node(4, null)))));
    }

    private static void printNode(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
