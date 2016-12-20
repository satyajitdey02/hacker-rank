package com.hackerrank.java;

import java.util.Scanner;

/**
 * Created by satyajit on 12/20/2016.
 */
public class OutputFormatting {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    int i1 = scanner.nextInt();
    String s2 = scanner.next();
    int i2 = scanner.nextInt();
    String s3 = scanner.next();
    int i3 = scanner.nextInt();

    System.out.println("================================");
    System.out.printf("%-15s%03d\n", s1, i1);
    System.out.printf("%-15s%03d\n", s2, i2);
    System.out.printf("%-15s%03d\n", s3, i3);
    System.out.println("================================");
  }
}
