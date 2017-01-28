package com.hackerrank.worldcodesprint9;

import java.util.Scanner;

/**
 * Created by satyajit on 1/28/17.
 */
public class GradingStudents {
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    while (n-->0) {
      int grade = in.nextInt();
      if(grade < 38) {
        System.out.println(grade);
        continue;
      }

      if(grade >= 38 && grade <= 40) {
        System.out.println(40);
        continue;
      }

      int gradeRemainder = grade % 5;
      if(gradeRemainder ==0) {
        System.out.println(grade);
        continue;
      }

      if((5 - gradeRemainder) < 3) {
        System.out.println(grade - gradeRemainder + 5);
        continue;
      }

      System.out.println(grade);
    }
    in.close();
  }
}
