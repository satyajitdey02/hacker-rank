package com.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * Created by satyajit on 1/19/17.
 */
public class RichieRich {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //int n = in.nextInt();
    //int k = in.nextInt();
    StringBuilder input = new StringBuilder(in.next());

    in.close();
    char firstHalf[];
    char secondHalf[];

    if (input.length() % 2 == 0) {
      firstHalf = input.substring(0, input.length() / 2).toCharArray();
      secondHalf = input.reverse().substring(0, input.length() / 2).toCharArray();
    } else {
      firstHalf = input.substring(0, input.length() / 2).toCharArray();
      secondHalf = input.reverse().substring((input.length() / 2) + 1, input.length()).toCharArray();
    }

    System.out.println(new String(firstHalf) + "-" + new String(secondHalf));
  }
}
