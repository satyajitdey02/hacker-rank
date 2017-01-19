package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * Created by satyajit on 1/19/17.
 */
public class MinMaxSum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    long sum = 0;
    for (int i = 0; i < 5; i++) {
      long input = scanner.nextLong();
      if (min > input) {
        min = input;
      }

      if (max < input) {
        max = input;
      }

      sum += input;
    }

    System.out.println((sum - max) + " " + (sum - min));
    scanner.close();
  }
}
