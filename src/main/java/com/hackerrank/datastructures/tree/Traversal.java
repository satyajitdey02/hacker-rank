package com.hackerrank.datastructures.tree;

/**
 * Created by satyajit on 1/6/17.
 */
public class Traversal {
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

  void postOrder(Node root) {
    if(root == null) {
      return;
    }

    if (root.left != null) {
      postOrder(root.left);
    }


    if (root.right != null) {
      postOrder(root.right);
    }

    System.out.print(root.data + " ");

  }

  void inOrder(Node root) {
    if(root == null) {
      return;
    }

    if (root.left != null) {
      inOrder(root.left);
    }

    System.out.print(root.data + " ");

    if (root.right != null) {
      inOrder(root.right);
    }
  }
}
