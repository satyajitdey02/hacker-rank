package com.hackerrank.datastructures.tree;

/**
 * Created by satyajit on 1/6/17.
 */
public class Node {
  int data;
  Node left;
  Node right;

  public Node() {

  }

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}
