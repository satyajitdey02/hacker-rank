package com.hackerrank.datastructures.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by satyajit on 1/18/17.
 */
public class Contacts2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Map<String, Integer> contacts = new HashMap<>();
    while (n-- > 0) {
      String query = in.next();
      String val = in.next();
      if ("add".equals(query)) {
        for (int i = 0; i < val.length(); i++) {
          String subStr = val.substring(0, i+1);
          if (contacts.containsKey(subStr)) {
            contacts.put(subStr, contacts.get(subStr) + 1);
          } else {
            contacts.put(subStr, 1);
          }
        }
      }

      if ("find".equals(query)) {
        System.out.println(contacts.get(val) == null ? 0 : contacts.get(val));
      }
    }
    in.close();
  }
}
