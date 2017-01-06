package com.hackerrank.datastructures.tree;

import java.util.Scanner;

/**
 * Created by satyajit on 1/6/17.
 */
public class Insertion {
  public static void main(String[] args) {
    Insertion insertion = new Insertion();
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while (t-- > 0) {
      int data = scan.nextInt();
      root = insertion.insert(root, data);
    }
    scan.close();
    int height = insertion.height(root);
    System.out.println(height);
  }

  int height(Node root) {
    if (root == null) {
      return -1;
    }

    int leftDepth = height(root.left);
    int rightDepth = height(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }

  Node insert(Node root, int data) {

    if (root == null) {
      return new Node(data);
    }

    Node current;
    if (data <= root.data) {
      current = insert(root.left, data);
      root.left = current;
    } else {
      current = insert(root.right, data);
      root.right = current;
    }

    return root;

  }
}
