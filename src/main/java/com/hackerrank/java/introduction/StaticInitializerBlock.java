package com.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class StaticInitializerBlock {
  static int B;
  static int H;
  static boolean flag;

  static {
    Scanner scanner = new Scanner(System.in);
    B = scanner.nextInt();
    H = scanner.nextInt();
    scanner.close();
    try {
      if (B <= 0 || H <= 0) {
        throw new Exception("Breadth and height must be positive");
      }
      flag = true;
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    if (flag) {
      int area = B * H;
      System.out.print(area);
    }

  }
}
