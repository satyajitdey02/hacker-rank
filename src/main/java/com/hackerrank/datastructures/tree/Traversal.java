package com.hackerrank.datastructures.tree;

import java.util.*;

/**
 * Created by satyajit on 1/6/17.
 */
public class Traversal {
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
    in.close();


    new Traversal().levelOrder(root);
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
    if (root == null) {
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
    if (root == null) {
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



  void levelOrder(Node root) {
    if (root == null) {
      return;
    }

    int height = height(root);
    List<Node> nodes = new ArrayList<>();
    nodes.add(root);
    for (int i = 1; i <= height; i++) {
      nodes.addAll(getNLevelNodes(root, (i + 1)));
    }

    for (Node node: nodes) {
      System.out.print(node.data + " ");
    }
  }

  List<Node> getNLevelNodes(Node root, int level) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<Node> nodes = new ArrayList<>();
    if (level == 1) {
      nodes.add(root);
    } else {
      nodes.addAll(getNLevelNodes(root.left, level - 1));
      nodes.addAll(getNLevelNodes(root.right, level - 1));
    }

    return nodes;
  }

  int height(Node root) {
    if (root == null) {
      return -1;
    }

    int leftDepth = height(root.left);
    int rightDepth = height(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }
}
