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
      int tempIn = in.nextInt();
      if (tempIn < 1 || tempIn > Math.pow(10, 6)) {
        return;
      }
      arr[(i + n - d) % n] = tempIn;
    }

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
