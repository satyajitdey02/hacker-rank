package com.hackerrank.datastructures.tree;

/**
 * Created by satyajit on 1/23/17.
 */
public class IsThisABinaryTree {
  //1 2 4 3 5 6 7
  public static void main(String[] args) {
    Node root = new Node(1);

    Node left = new Node(2);
    left.left = new Node(4);
    left.right = new Node(3);

    Node right = new Node(5);
    right.left = new Node(6);
    right.right = new Node(7);

    root.left = left;
    root.right = right;

    Traversal traversal = new Traversal();
    traversal.preOrder(root);
    System.out.println();
    traversal.postOrder(root);
    System.out.println();
    traversal.inOrder(root);
    System.out.println();
    traversal.levelOrder(root);
    //System.out.println(checkBST(root));
  }

  static boolean checkBST(Node root) {
    if (root == null) {
      return false;
    }

    if (root.left != null) {
      return root.data > root.left.data && checkBST(root.left);
    }

    return root.right != null && root.data < root.right.data && checkBST(root.right);
  }

  /*static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }*/
}
