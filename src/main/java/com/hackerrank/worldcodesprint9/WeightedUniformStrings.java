package com.hackerrank.worldcodesprint9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by satyajit on 1/28/17.
 */
public class WeightedUniformStrings {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    String string = in.next();
    Map<Integer, String> U = new HashMap<>();
    char chars[] = string.toCharArray();
    char prevChar = 0;
    StringBuilder uniqueSubString = new StringBuilder();

    for (int i = 0; i < chars.length; i++) {
      if (i == 0) {
        prevChar = chars[0];
        U.put(chars[0] - 'a' + 1, String.valueOf(chars[0]));
        uniqueSubString.append(chars[0]);
        continue;
      }

      if (chars[i] == prevChar) {
        prevChar = chars[i];
        uniqueSubString.append(chars[i]);
        U.put((chars[i] - 'a' + 1) * uniqueSubString.length(), uniqueSubString.toString());
        continue;
      }


      prevChar = chars[i];
      uniqueSubString = new StringBuilder();
      uniqueSubString.append(chars[i]);
      U.put((chars[i] - 'a' + 1) * uniqueSubString.length(), uniqueSubString.toString());
    }

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int xi = in.nextInt();
      System.out.println(U.get(xi) != null ? "Yes" : "No");
    }

    in.close();
  }
}
