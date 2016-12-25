package com.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class StringsIntroduction {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String a = scanner.nextLine();
    String b = scanner.nextLine();
    scanner.close();

    System.out.println(a.length() + b.length());
    System.out.println(a.compareTo(b) > 0 ? "Yes" : "No");

    a = a.substring(0, 1).toUpperCase().concat(a.substring(1));
    b = b.substring(0, 1).toUpperCase().concat(b.substring(1));
    System.out.printf("%s %s", a, b);
  }
}
