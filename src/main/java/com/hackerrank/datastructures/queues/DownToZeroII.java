package com.hackerrank.datastructures.queues;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by satyajit on 1/21/17.
 */
public class DownToZeroII {
  static Map<Integer, Integer> allFactorsMap;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    try {
      while (true) {
        int n = in.nextInt();
        int moves = reduce(n);
        System.out.println(moves);
      }
    } catch (Exception e) {
      System.out.println("Input Aborted!");
    } finally {
      in.close();
    }
  }

  private static int  reduce(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1 + reduce(0);
    }
    if (n == 2) {
      return 1 + reduce(1);
    }
    if (n == 3) {
      return 1 + reduce(2);
    }

    if (isPrime(n)) {
      return 1 + reduce(n - 1);
    }

    int move =0;
    findAllFactors(n);
    for (Map.Entry<Integer, Integer> entry : allFactorsMap.entrySet()) {
      int maxFactor = Math.max(entry.getKey(), entry.getValue());
      move = 1 + reduce(maxFactor);
    }

    return move;
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

    for (int i = 3; i * i < number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

  private static void findAllFactors(int n) {
    allFactorsMap = new TreeMap<>();
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        allFactorsMap.put(i, n / i);
      }
    }
  }

  private static void printALlFactors() {
    for (Map.Entry<Integer, Integer> entry : allFactorsMap.entrySet()) {
      System.out.printf("((%d, %d)%n", entry.getKey(), entry.getValue());
    }
  }
}
