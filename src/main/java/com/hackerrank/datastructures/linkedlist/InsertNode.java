package com.hackerrank.datastructures.linkedlist;

import java.util.Scanner;

/**
 * Created by satyajit on 1/2/17.
 */
public class InsertNode {
  public static void main(String[] args) {

    InsertNode insertNode = new InsertNode();
    Node head = insertNode.insertAtTail(null,5);
    System.out.println(head.data);
    head = insertNode.insertAtTail(head,10);
    System.out.println(head.data);
    head = insertNode.insertAtTail(head,15);
    System.out.println(head.data);
  }

  private Node insertAtTail(Node head, int data) {

    if (head == null) {
      Node node = new Node();
      node.data = data;
      return node;
    }

    if (head.next == null) {
      Node node = new Node();
      node.data = data;
      head.next = node;
      return head;
    }

    head = insertAtTail(head.next, data);
    return head;
  }

}
