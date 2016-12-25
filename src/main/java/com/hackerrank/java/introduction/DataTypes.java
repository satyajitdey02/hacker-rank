package com.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by satyajit on 12/24/16.
 */
public class DataTypes {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      try {
        long value = scanner.nextLong();
        System.out.printf("%d can be fitted in:\n", value);
        if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
          System.out.println("* byte");
        }

        if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
          System.out.println("* short");
        }

        if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
          System.out.println("* int");
        }

        if (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE) {
          System.out.println("* long");
        }
      } catch (Exception e) {
        System.out.println(scanner.next() + " can't be fitted anywhere.");
      }
    }

    scanner.close();
  }
}
