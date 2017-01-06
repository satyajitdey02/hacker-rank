package com.hackerrank.datastructures.tree;

/**
 * Created by satyajit on 1/6/17.
 */
public class Tree {
  public static void main(String[] args) {

  }

  void preOrder(Node root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");

    if (root.left != null) {
      preOrder(root.left);
    }

    if (root.right != null) {
      preOrder(root.right);
    }
  }
}
