package com.hackerrank.java;

import java.util.Scanner;

/**
 * Created by satyajit on 12/24/16.
 */
public class LoopsI {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    if (input >= 2 && input <= 20) {
      for (int i = 1; i <= 10; i++) {
        System.out.printf("%s x %s = %s\n", input, i, input * i);
      }
    }
  }
}
