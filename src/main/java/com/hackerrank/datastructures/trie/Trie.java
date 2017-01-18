package com.hackerrank.datastructures.trie;

import java.util.*;

/**
 * Created by satyajit on 1/18/17.
 */
public class Trie {
  private String value;
  private Map<Character, Trie> children = new HashMap<>();
  private boolean end = false;

  public Trie() {

  }

  private Trie(String value) {
    this.value = value;
  }

  public void insert(String value) {
    char[] chars = value.toCharArray();
    Trie trie = this;
    for (char c : chars) {
      if (trie.children.get(c) == null) {
        trie.add(c);
      }
      trie = trie.children.get(c);
    }

    trie.end = true;
  }

  private void add(char c) {
    StringBuilder sb = new StringBuilder();
    if (this.value == null) {
      sb.append(c);
    } else {
      sb.append(this.value).append(c);
    }

    this.children.put(c, new Trie(sb.toString()));
  }

  public List<String> search(String prefix) {
    Trie trie = this;
    for (char c : prefix.toCharArray()) {
      if (!trie.children.containsKey(c)) {
        return Collections.emptyList();
      }
      trie = trie.children.get(c);
    }
    return trie.fetchMatchedPrefixWords();
  }

  private List<String> fetchMatchedPrefixWords() {
    List<String> results = new ArrayList<>();
    if (this.end) {
      results.add(this.value);
    }

    for (Map.Entry<Character, Trie> entry : children.entrySet()) {
      Trie trie = entry.getValue();
      List<String> childPrefixes = trie.fetchMatchedPrefixWords();
      results.addAll(childPrefixes);
    }

    return results;
  }
}
