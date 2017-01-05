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
    head = deleteNode.deleteNthNode(head, 3);

    new LinkedListPrinter(head).print();
  }

  private Node deleteNthNode(Node head, int position) {

    if (position == 0) {
      return head.next;
    }

    Node currentNode = head;
    Node prevNode = head;
    for (int i = 0; i < position; i++) {
      prevNode = currentNode;
      if (currentNode.next == null) {
        break;
      }
      currentNode = currentNode.next;
    }

    prevNode.next = currentNode.next;
    return head;
  }
}
