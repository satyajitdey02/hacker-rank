package com.hackerrank.datastructures.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by satyajit on 1/19/17.
 */
public class NoPrefixSet {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] inputs = new String[n];
    Map<String, Integer> stringSet = new HashMap<>();
    for (int i = 0; i < n; i++) {
      inputs[i] = in.next();
      for (int j = 0; j < inputs[i].length(); j++) {
        String subStr = inputs[i].substring(0, j + 1);
        if (stringSet.containsKey(subStr)) {
          stringSet.put(subStr, stringSet.get(subStr) + 1);
        } else {
          stringSet.put(subStr, 1);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (stringSet.get(inputs[i]) > 1) {
        System.out.println("BAD SET");
        for(int j=i+1;j<n;j++) {
          if(inputs[j].startsWith(inputs[i])) {
            System.out.println(inputs[j]);
            break;
          }
        }

        return;
      }
    }

    System.out.println("GOOD SET");
    in.close();
  }
}
