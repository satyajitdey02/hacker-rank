package com.helping.code;

public class ReverseLinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        //printNode(head);
        Node result =reverse(head);

        printNode(result);
    }

    private static void printNode(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
