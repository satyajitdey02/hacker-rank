package com.hackerrank.tutorials;

import java.util.Scanner;

/**
 * Created by satyajit on 1/13/17.
 */
public class Day25 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    while (T-- > 0) {

      int n = in.nextInt();
      if (n <= 1) {
        System.out.println("Not Prime");
        continue;
      }

      if (n <= 3) {
        System.out.println("Prime");
        continue;
      }

      if (n % 2 == 0) {
        System.out.println("Not Prime");
        continue;
      }

      boolean isPrime = true;
      for (int i = 2; (i * i) <= n; i++) {
        if ((n % i) == 0 /*|| (n % (i+2) == 0)*/) {
          isPrime = false;
          break;
        }
      }

      System.out.println(isPrime ? "Prime" : "Not Prime");
    }
    in.close();
  }
}
