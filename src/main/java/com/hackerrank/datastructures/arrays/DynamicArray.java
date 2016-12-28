package com.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * Created by satyajit on 12/28/16.
 */
public class DynamicArray {
  public static void main(String[] args) {
    int lastAns = 0;

    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    if (N < 1 || N > Math.pow(10, 5)) {
      return;
    }

    int s[][] = new int[N][];

    int Q = in.nextInt();
    if (Q < 1 || Q > Math.pow(10, 5)) {
      return;
    }

    for (int i = 0; i < Q; i++) {
      int qT = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();
      if (qT < 1 || qT > 2) {
        return;
      }

      if (x < 0 || x > Math.pow(10, 9)) {
        return;
      }

      if (y < 0 || y > Math.pow(10, 9)) {
        return;
      }

      int index = (x ^ lastAns) % N;
      if (qT == 1) {
        if (s[index] == null || s[index].length == 0) {
          s[index] = new int[1];
          s[index][0] = y;
        } else {
          int tempArr[] = s[index];
          s[index] = new int[tempArr.length + 1];
          System.arraycopy(s[index], 0, tempArr, 0, s[index].length - 1);
          /*for (int c = 0; c < tempArr.length; c++) {
            s[index][c] = tempArr[c];
          }*/
          s[index][tempArr.length] = y;
        }

      } else if (qT == 2) {
        lastAns = s[index][y % s[index].length];
        System.out.println(lastAns);
      }
    }
    in.close();

  }
}
