package com.hackerrank.worldcodesprint9;

import java.util.*;

/**
 * Created by satyajit on 1/28/17.
 */
public class WeightedUniformStrings {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String string = in.next();
    if (string == null || string.isEmpty()) {
      return;
    }

    Set<Integer> U = new HashSet<>();
    char chars[] = string.toCharArray();
    char prevChar = 0;
    StringBuilder uniqueSubString = new StringBuilder();

    for (int i = 0; i < chars.length; i++) {
      if (i == 0) {
        prevChar = chars[0];
        U.add(chars[0] - 'a' + 1);
        uniqueSubString.append(chars[0]);
        continue;
      }

      if (chars[i] == prevChar) {
        prevChar = chars[i];
        uniqueSubString.append(chars[i]);
        U.add((chars[i] - 'a' + 1) * uniqueSubString.length());
        continue;
      }


      prevChar = chars[i];
      uniqueSubString = new StringBuilder();
      uniqueSubString.append(chars[i]);
      U.add((chars[i] - 'a' + 1) * uniqueSubString.length());
    }

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int xi = in.nextInt();
      System.out.println(U.contains(xi)? "Yes" : "No");
    }
    in.close();
  }
}
