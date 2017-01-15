package com.hackerrank.datastructures.queues;

/**
 * Created by satyajit on 1/15/17.
 */
public class CastleGrid {
  public static void main(String[] args) {
    String[][] grids = {{".", "X", "."}, {".", "X", "."}, {".", ".", "."}};
    int a = 0, b = 0, c = 2, d = 2;
    for (int i = a; i <= c; i++) {
      for (int j = b; j <= d; j++) {
        System.out.println(grids[i][j]);
      }
    }
  }
}
