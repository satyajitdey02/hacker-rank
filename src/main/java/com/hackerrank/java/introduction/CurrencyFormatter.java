package com.hackerrank.java.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class CurrencyFormatter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double input = scanner.nextDouble();
    scanner.close();

    if(input < 0 || input > Math.pow(10, 9)) {
      return;
    }

    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.printf("US: %s\n", currencyInstance.format(input));

    currencyInstance = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
    System.out.printf("India: %s\n", currencyInstance.format(input));

    currencyInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);
    System.out.printf("China: %s\n", currencyInstance.format(input));

    currencyInstance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    System.out.printf("France: %s\n", currencyInstance.format(input));
  }
}
