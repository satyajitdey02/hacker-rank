package com.hackerrank.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by satyajit on 1/22/17.
 */
public class SwapNodesAlgo {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    Node root = new Node(1);
    Queue<Node> tree = new LinkedList<>();
    tree.offer(root);
    while (N-- > 0) {
      Node current = tree.poll();
      int a = in.nextInt();
      int b = in.nextInt();
      if (a != -1) {
        current.left = new Node(a);
        tree.offer(current.left);
      }

      if (b != -1) {
        current.right = new Node(b);
        tree.offer(current.right);
      }
    }

    int T = in.nextInt();
    while (T-- > 0) {
      swapNKLevelNodes(root, in.nextInt(), 1);
      printInOrder(root);
      System.out.println();
    }

    in.close();
  }

  static void swapNKLevelNodes(Node root, int level, int depth) {
    if (root == null) {
      return;
    }

    if (depth % level == 0) {
      Node left = root.left;
      root.left = root.right;
      root.right = left;
    }

    swapNKLevelNodes(root.left, level, depth + 1);
    swapNKLevelNodes(root.right, level, depth + 1);
  }

  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  static void printInOrder(Node root) {
    if (root == null) {
      return;
    }

    if (root.left != null) {
      printInOrder(root.left);
    }

    System.out.print(root.data + " ");

    if (root.right != null) {
      printInOrder(root.right);
    }
  }

}
