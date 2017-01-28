package com.codeforces.contest;

import java.util.Scanner;

/**
 * Created by satyajit on 1/23/17.
 */
public class FrodoAndPillows {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    if (n == m) {
      System.out.println(1);
    }
    
    in.close();
  }
}
