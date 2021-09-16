package com.hackerrank.datastructures.linkedlist;

/**
 * Created by satyajit on 1/5/17.
 */
public class LinkedListPrinter {
  private Node head;

  public static void main(String[] args) {
    Node secondNode = new Node();
    secondNode.data = 2;

    Node firstNode = new Node(3, secondNode);

    LinkedListPrinter printer = new LinkedListPrinter(firstNode);
    printer.print();
  }

  public LinkedListPrinter(Node head) {
    this.head = head;
  }

  /*Print the Elements of a Linked List*/
  void print() {
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

  void printReverse(Node head) {
    if(head == null) {
      return;
    }

    if(head.next == null) {
      System.out.println(head.data);
    }

    printReverse(head.next);

  }

}
