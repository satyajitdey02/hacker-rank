package com.hackerrank.java;

import java.util.Scanner;

/**
 * Created by satyajit on 12/24/16.
 */
public class LoopsII {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int q = scanner.nextInt();
    if (q < 0 && q > 500) {
      return;
    }

    for (int i = 0; i < q; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int n = scanner.nextInt();

      if (a < 0 && a > 500) {
        return;
      }

      if (b < 0 && b > 500) {
        return;
      }

      if (n < 1 && n > 15) {
        return;
      }

      for (int j = 0; j < n; j++) {
        int result = a;
        for (int k = 0; k <= j; k++) {
          result += Math.pow(2, k) * b;
        }

        System.out.printf("%d ", result);
      }

      System.out.println();
    }

    scanner.close();
  }
}
