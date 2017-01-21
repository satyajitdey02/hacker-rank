package com.hackerrank.utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by satyajit on 1/20/17.
 */
public class MathUtils {
  private MathUtils() {
  }

  public static boolean isPrime(int number) {
    if (number == 1) {
      return false;
    }
    if (number == 2) {
      return true;
    }

    if (number % 2 == 0) {
      return false;
    }

    for (int i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static int largestPrimeFactorOf(int number) {
    int result;
    for (result = 2; result <= number; result++) {
      if (number % result == 0) {
        number = number / result;
        result--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    try {
      while (true) {
        int q = in.nextInt();
        int n = in.nextInt();
        if (q == 1) {
          System.out.println("Primality of " + n + ": " + isPrime(n));
        } else if (q == 2) {
          System.out.println("LPF of " + n + ": " + isPrime(n));
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      in.close();
    }
  }
}
