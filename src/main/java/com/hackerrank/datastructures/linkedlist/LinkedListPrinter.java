package com.hackerrank.datastructures.linkedlist;

/**
 * Created by satyajit on 1/5/17.
 */
public class LinkedListPrinter {
  private Node head;

  public LinkedListPrinter(Node head) {
    this.head = head;
  }

  /*Print the Elements of a Linked List*/
  public void print() {
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

}
