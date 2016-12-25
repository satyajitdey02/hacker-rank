package com.hackerrank.java;

import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class EOF {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    for(int i = 1; scanner.hasNext(); i++){
      System.out.println(i + " " + scanner.nextLine());
    }

    // This approach works also
    /*int count = 1;
    while(scanner.hasNext()) {
      System.out.println(count + " " + scanner.nextLine());
      count++;
    }*/
    scanner.close();
  }
}
