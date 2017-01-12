package com.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by satyajit on 1/12/17.
 */
public class CamelCase {
  public static void main(String[] args) {
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
}
