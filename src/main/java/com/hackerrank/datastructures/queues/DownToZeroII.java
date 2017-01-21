package com.hackerrank.datastructures.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by satyajit on 1/21/17.
 */
public class DownToZeroII {
  static int currentMinDepth = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    while (q-- > 0) {
      int n = in.nextInt();
      currentMinDepth = Integer.MAX_VALUE;
      FactorsTree tree = new FactorsTree(n, 0);
      System.out.println(tree.getDownToZeroStep());
    }
    in.close();
  }

  static class FactorsTree {
    int value;
    int depth;
    List<FactorsTree> nodes = new ArrayList<>();

    public FactorsTree(int value, int depth) {
      this.value = value;
      this.depth = depth;
      if (this.value == 0) {
        if (this.depth < currentMinDepth) {
          currentMinDepth = this.depth;
        }
        return;
      }

      if (this.value == 1) {
        if (this.depth < currentMinDepth) {
          FactorsTree tree = new FactorsTree(0, this.depth + 1);
          this.nodes.add(tree);
        }

        return;
      }

      if (this.value == 2) {
        if (this.depth < currentMinDepth) {
          FactorsTree tree = new FactorsTree(1, this.depth + 1);
          this.nodes.add(tree);
        }

        return;
      }

      if (this.value == 3) {
        if (this.depth < currentMinDepth) {
          FactorsTree tree = new FactorsTree(2, this.depth + 1);
          this.nodes.add(tree);
        }

        return;
      }

      if (isPrime(this.value)) {
        if (this.depth < currentMinDepth) {
          FactorsTree tree = new FactorsTree(this.value - 1, this.depth + 1);
          this.nodes.add(tree);
        }

        return;
      }

      for (int i = 2; i * i <= this.value; i++) {
        if (this.value % i == 0 && this.depth < currentMinDepth) {
          FactorsTree tree = new FactorsTree(Math.max(i, this.value / i), this.depth + 1);
          this.nodes.add(tree);
        }
      }

      if (this.depth < currentMinDepth) {
        FactorsTree tree = new FactorsTree(this.value - 1, this.depth + 1);
        this.nodes.add(tree);
      }
    }

    private boolean isPrime(int number) {
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

    public int getDownToZeroStep() {
      return currentMinDepth;
    }
  }
}
