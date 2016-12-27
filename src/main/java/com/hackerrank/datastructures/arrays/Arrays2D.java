package com.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * Created by satyajit on 12/27/16.
 */
public class Arrays2D {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int inArr[][] = new int[6][6];
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        int input = in.nextInt();
        if (input < -9 || input > 9) {
          return;
        }
        inArr[i][j] = input;
      }
    }
    in.close();

    int result = -63;
    for (int i = 1; i < 5; i++) {
      for (int j = 1; j < 5; j++) {
        int hourGlassVal = inArr[i - 1][j - 1] + inArr[i - 1][j] + inArr[i - 1][j + 1] + inArr[i][j] +
            inArr[i + 1][j - 1] + inArr[i + 1][j] + inArr[i + 1][j + 1];

        if (hourGlassVal > result) {
          result = hourGlassVal;
        }
      }
    }

    System.out.println(result);
  }
}
