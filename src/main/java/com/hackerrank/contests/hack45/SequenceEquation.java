package com.hackerrank.contests.hack45;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by satyajit on 1/18/17.
 */
public class SequenceEquation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Map<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      int Pn = in.nextInt();
      treeMap.put(Pn, i + 1);
    }
    in.close();

    for (int i = 0; i < n; i++) {
      System.out.println(treeMap.get(treeMap.get(i + 1)));
    }
  }
}
