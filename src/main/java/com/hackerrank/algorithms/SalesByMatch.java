package com.hackerrank.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SalesByMatch {
    public static void main(String[] args) {
        System.out.println(sockMerchant(9, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        Collections.sort(ar);
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i : ar) {
            if (!stack.empty() && stack.peek() == i) {
                stack.pop();
                count++;
            } else {
                stack.push(i);
            }
        }
        return count;
    }
}
