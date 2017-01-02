package com.hackerrank.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by satyajit on 1/2/17.
 */
public class SparseArrays {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    List<String> inputStrings = new ArrayList<String>();
    for (int i = 0; i < N; i++) {
      inputStrings.add(in.next());
    }

    int Q = in.nextInt();
    for (int j = 0; j < Q; j++) {

      String queryString = in.next();
      int count = 0;
      if (inputStrings.contains(queryString)) {
        for (String s : inputStrings) {
          count = queryString.equals(s) ? count + 1 : count;
        }
      }

      System.out.println(count);

    }
    in.close();
  }
}
