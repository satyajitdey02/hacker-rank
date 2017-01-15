package com.hackerrank.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 1/15/17.
 */
public class TrieNode {
  List<TrieNode> nodes = new ArrayList<TrieNode>();
  boolean end;

  private TrieNode() {
  }

  public static TrieNode createRoot() {
    TrieNode root = new TrieNode();
    root.put('0');
    return root;
  }

  public boolean containsKey(char ch) {
    return nodes.get(ch - 'a') != null;
  }

  public void put(char ch) {
    nodes.add(ch - 'a' < 0 ? 0 : ch - 'a', new TrieNode());
  }

  public TrieNode get(char ch) {
    return nodes.get(ch - 'a' < 0 ? 0 : ch - 'a');
  }

  public void setEnd() {
    this.end = true;
  }

  public boolean isEnd() {
    return this.end;
  }
}
