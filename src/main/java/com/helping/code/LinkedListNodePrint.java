package com.helping.code;

public class LinkedListNodePrint {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        Node n4 = new Node(4, n3);

        printNode(n4);
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
