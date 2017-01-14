package com.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by satyajit on 1/12/17.
 */
public class CamelCase {
  public static void main(String[] args) {
    //typicalSolution();
    betterSolution();
  }

  private static void typicalSolution() {
    Scanner in = new Scanner(System.in);
    String camelCaseStr = in.next();
    in.close();

    int wordCount = 0;
    char chars[] = camelCaseStr.toCharArray();
    if (chars[0] < 'A' || chars[0] > 'Z') {
      wordCount++;
    }

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        wordCount++;
      }
    }

    System.out.println(wordCount);
  }

  private static void betterSolution() {
    Scanner in = new Scanner(System.in);
    String inputStr = in.next();
    in.close();

    String[] words = inputStr.split("[A-Z]]");
    if (inputStr.charAt(0) < 'A' || inputStr.charAt(0) > 'Z') {
      System.out.println(words.length + 1);
      return;
    }

    System.out.println(words.length);
  }
}
