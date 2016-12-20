package com.hackerrank.java;

import java.util.Scanner;

/**
 * Created by satyajit on 12/20/2016.
 */
public class JavaIfElse {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    if (input % 2 != 0) {
      System.out.println("Weird");
    } else {
      if (input >= 2 && input <= 5) {
        System.out.println("Not Weird");
      } else if (input >= 6 && input <= 20) {
        System.out.println("Weird");
      } else if (input > 20) {
        System.out.println("Not Weird");
      }
    }
  }
}
