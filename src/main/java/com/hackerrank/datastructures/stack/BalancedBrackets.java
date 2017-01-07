package com.hackerrank.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by satyajit on 1/7/17.
 */
public class BalancedBrackets {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String validInputStr = "[{()}]";
    do {
      String inputStr = in.nextLine();
      if (inputStr != null && !inputStr.isEmpty()) {
        char[] bracketsArr = inputStr.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : bracketsArr) {
          if (validInputStr.indexOf(c) < 0) {
            return;
          }

          Character character = c;
          if (!stack.empty()) {
            if (character == ')' && stack.peek() == '(') {
              stack.pop();
              continue;
            }

            if (character == '}' && stack.peek() == '{') {
              stack.pop();
              continue;
            }

            if (character == ']' && stack.peek() == '[') {
              stack.pop();
              continue;
            }
          }

          stack.push(character);

        }

        System.out.println(stack.empty() ? "YES" : "NO");
      }
    } while (n-- > 0);
    in.close();
  }
}
