package com.hackerrank.datastructures.arrays;

import java.util.Arrays;
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


    for (int i = 0; i < d; i++) {
      int temp = arr[0];
      for (int j = 0; j < n - 1; j++) {
        arr[j] = arr[j + 1];
      }
      arr[n - 1] = temp;
    }

    for (int i = 0; i < n; i++) {
      System.out.printf("%s ", arr[i]);
    }
  }
}
