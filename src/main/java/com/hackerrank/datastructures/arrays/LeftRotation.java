package com.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * Created by satyajit on 1/2/17.
 */
public class LeftRotation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (n < 1 || n > Math.pow(10, 5)) {
      return;
    }

    int d = in.nextInt();
    if (d < 1 || d > n) {
      return;
    }

    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
      if (arr[i] < 1 || arr[i] > Math.pow(10, 6)) {
        return;
      }
    }
    in.close();

    if (d > (n / 2)) {
      print(rightRotate(n - d, arr));
    } else {
      print(leftRotate(d, arr));
    }

  }

  private static void print(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%s ", arr[i]);
    }
  }

  private static int[] rightRotate(int d, int arr[]) {
    if (arr.length == 1) {
      return arr;
    }

    for (int i = 0; i < d; i++) {
      int temp = arr[arr.length - 1];
      for (int j = arr.length - 2; j >= 0; j--) {
        arr[j + 1] = arr[j];
      }

      arr[0] = temp;
    }

    return arr;
  }

  private static int[] leftRotate(int d, int arr[]) {
    if (arr.length == 1) {
      return arr;
    }

    for (int i = 0; i < d; i++) {
      int temp = arr[0];
      for (int j = 0; j < arr.length - 1; j++) {
        arr[j] = arr[j + 1];
      }
      arr[arr.length - 1] = temp;
    }

    return arr;
  }
}
