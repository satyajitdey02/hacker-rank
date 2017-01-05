package com.hackerrank.datastructures.linkedlist;

/**
 * Created by satyajit on 1/5/17.
 */
public class DeleteNode {
  public static void main(String[] args) {
    InsertNode insertNode = new InsertNode();
    Node head = insertNode.insertAtTail(null, 5);
    head = insertNode.insertAtTail(head, 10);
    head = insertNode.insertAtTail(head, 15);
    head = insertNode.insertAtTail(head, 20);

    DeleteNode deleteNode = new DeleteNode();
    head = deleteNode.deleteNthNode(head, 5);

    new LinkedListPrinter(head).print();
  }

  private Node deleteNthNode(Node head, int position) {
    if (position > 0 && head.next == null) {
      return head;
    }

    if (position == 0 || head.next == null) {
      return head.next;
    }

    head.next = deleteNthNode(head.next, position - 1);
    return head;
  }
}
