package com.hackerrank.datastructures.linkedlist;

import java.util.Scanner;

/**
 * Created by satyajit on 1/2/17.
 */
public class InsertNode {
  public static void main(String[] args) {

    InsertNode insertNode = new InsertNode();
    Node head = insertNode.insertAtHead(null, 5);
    head = insertNode.insertAtHead(head, 10);
    head = insertNode.insertAtHead(head, 15);

    insertNode.print(head);
  }

  /*Inserts a node at the head of a linked list*/
  private Node insertAtHead(Node head, int data) {
    Node newNode = new Node();
    newNode.data = data;

    if (head == null) {
      return newNode;
    }

    Node first = head;
    newNode.next = first;
    head = newNode;

    return head;
  }

  /*Inserts a Node at the Tail of a Linked List*/
  private Node insertAtTail(Node head, int data) {

    Node newNode = new Node();
    newNode.data = data;

    if (head == null) {
      return newNode;
    }

    Node last = head;
    while (last.next != null) {
      last = last.next;
    }

    last.next = newNode;
    return head;
  }

  /*Print the Elements of a Linked List*/
  private void print(Node head) {
    while(head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }
}
