package com.hackerrank.datastructures.linkedlist;

import java.util.Scanner;

/**
 * Created by satyajit on 1/2/17.
 */
public class InsertNode {
  public static void main(String[] args) {

    InsertNode insertNode = new InsertNode();
    Node head = insertNode.insertAtTail(null, 5);
    head = insertNode.insertAtTail(head, 10);
    head = insertNode.insertAtTail(head, 20);

    head = insertNode.insetAtNthPosition(head, 15, 0);

    insertNode.print(head);
  }

  /*Insert a node at Nth Position*/
  private Node insetAtNthPosition(Node head, int data, int position) {
    Node newNode = new Node();
    newNode.data = data;

    if (head == null) {
      return newNode;
    }

    Node currentNode = head;
    Node prevNode = head;
    for (int i = 0; i < position; i++) {
      prevNode = currentNode;
      currentNode = currentNode.next;
    }

    prevNode.next = newNode;
    newNode.next = currentNode;

    return head;
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
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }
}
