package com.hackerrank.java;

import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class IntToString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String s = String.valueOf(n);
    //String s = new Integer(n).toString();
    //String s = Integer.toString(n);
    System.out.println(s);
    scanner.close();
  }
}
