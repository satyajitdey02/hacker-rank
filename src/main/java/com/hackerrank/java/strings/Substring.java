package com.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class Substring {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    int start = scanner.nextInt();
    int end = scanner.nextInt();
    scanner.close();

    if (s.length() < 1 || s.length() > 100) {
      return;
    }

    if (start < 0 || start > s.length() || start >= end) {
      return;
    }

    if (end < 0 || end > s.length()) {
      return;
    }

    System.out.println(s.substring(start, end));
  }
}
