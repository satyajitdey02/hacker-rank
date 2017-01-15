package com.hackerrank.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 1/15/17.
 */
public class Trie {
  TrieNode root;
  List<String> results = new ArrayList<String>();

  public Trie() {
    this.root = TrieNode.createRoot();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!node.containsKey(currentChar)) {
        node.put(currentChar);
      }
      node = node.get(currentChar);
    }

    node.setEnd();
  }

  public List<String> search(String key) {
    TrieNode node = root;
    return results;
  }
}
