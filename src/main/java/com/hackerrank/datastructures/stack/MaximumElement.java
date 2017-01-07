package com.hackerrank.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by satyajit on 1/7/17.
 */
public class MaximumElement {
  static class Element {
    int value;
    int maxValue;

    Element(int value, int maxValue) {
      this.value = value;
      this.maxValue = maxValue;
    }
  }

  public static void main(String[] args) {
    Stack<Element> stack = new Stack<Element>();
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    do {
      int type = in.nextInt();
      if (type == 1) {
        int x = in.nextInt();
        if (stack.empty()) {
          stack.push(new Element(x, x));
        } else {
          stack.push(new Element(x, Math.max(x, stack.peek().maxValue)));
        }
        continue;
      }

      if (type == 2 && !stack.empty()) {
        stack.pop();
        continue;
      }

      if (type == 3) {
        System.out.println(stack.empty() ? Integer.MIN_VALUE : stack.peek().maxValue);
      }

    } while (N-- >= 0);

    in.close();
  }
}




