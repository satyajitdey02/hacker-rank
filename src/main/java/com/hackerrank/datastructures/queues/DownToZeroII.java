package com.hackerrank.datastructures.queues;

import com.hackerrank.utils.MathUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by satyajit on 1/21/17.
 */
public class DownToZeroII {
  static Map<Integer, Integer> leastDiffFactorsMap = new HashMap<>();

  public static void main(String[] args) {
    //Scanner in = new Scanner(System.in);
    //int q = in.nextInt();
    //while (q-- > 0) {
      int n = 603900;//in.nextInt();
      int move = reduce(n);
      System.out.println(move);
      //int move2 = reduce(n - 1);
      //System.out.println(move2);
      //System.out.print(n + "-->");


      //System.out.println(move > move2 ? move2 : move);
    //}
    //in.close();

  }

  private static int reduce(int n) {
    int move = 0;
    //System.out.print(n + "-->");
    while (n != 0) {
      if (n == 1) {
        // System.out.print("1-1>-->0");
        move++;
        break;
      }

      if (isPrime(n)) {
        //System.out.print(n + "-1-->");
        n = n - 1;
        move++;
        continue;
      }

      //int fA = largestPrimeFactorOf(n);
      //int fB = n / fA;
      n = leastDiffMaxFactor(n);//Math.max(fA, fB);
      //System.out.print(String.format("max(%d, %d)-->", fA, fB));

      move++;
    }
    return move;
  }

  private static int leastDiffMaxFactor(int n) {
    if (leastDiffFactorsMap.get(n) != null) {
      return leastDiffFactorsMap.get(n);
    }

    if (isPrime(n)) {
      leastDiffFactorsMap.put(n, n);
      return n;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int diff = Integer.MAX_VALUE;
    int result = n;
    for (int f1 = 2; f1 < Math.sqrt(n) + 1; f1++) {
      //for (int f1 = (int)Math.sqrt(n); f1 <= n; f1++) {
      if (n % f1 == 0) {
        int f2 = n / f1;
        result = Math.max(f1, f2);
        /*if (diff > Math.abs(f1 - f2)) {
          diff = Math.abs(f1 - f2);
          result = Math.max(f1, f2);
        }*/

      }
    }

    leastDiffFactorsMap.put(n, result);
    return result;
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
}
