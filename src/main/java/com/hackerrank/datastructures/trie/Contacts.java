package com.hackerrank.datastructures.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by satyajit on 1/15/17.
 */
public class Contacts {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Trie trie = Trie.createRoot();
    while (n-->0) {
      String query = in.next();
      String val = in.next();
      if("add".equalsIgnoreCase(query)) {
        trie.insert(val);
        continue;
      }

      if("find".equalsIgnoreCase(query)) {
        List<String> results= trie.search(val);
        System.out.println(results == null ? 0: results.size());
      }
    }
    in.close();
  }

  static class Trie {
    char ch;
    private String value;
    Trie[] childs = new Trie[26];
    boolean end;

    public Trie(char ch) {
      this.ch = ch;
    }

    public static Trie createRoot() {
      Trie root = new Trie('0');
      root.value = "";
      return root;
    }

    public boolean isEnd() {
      return end;
    }

    public void setEnd() {
      this.end = true;
    }

    private boolean containsKey(char ch) {
      if (childs == null || childs.length <= 0) {
        return false;
      }

      return childs[ch - 'a'] != null;
    }

    public void insert(String str) {

      char[] chars = str.toCharArray();
      Trie trie = this;
      String val = "";
      for (char c : chars) {
        Trie newChild;
        if (!trie.containsKey(c)) {
          newChild = new Trie(c);
          if (trie.value == null || trie.value.isEmpty()) {
            val = Character.toString(c);
          } else {
            val += c;
          }
          newChild.value = val;
          trie.childs[c - 'a'] = newChild;

        } else {
          val += c;
        }

        trie = trie.childs[c - 'a'];
      }

      trie.setEnd();
    }

    public List<String> search(String word) {
      List<String> results = new ArrayList<String>();
      char[] searchChars = word.toLowerCase().toCharArray();
      Trie matchingNode = this;
      boolean matched = false;
      for (char c : searchChars) {
        //Trie[] nodes = this.childs;
        matchingNode = matchingNode.childs[c - 'a'];
        if (matchingNode != null) {
          matched = true;
        } else {
          matched = false;
          break;
        }
      }
      if (matched) {
        fetchmatchingPrefixStr(matchingNode, results);
      }

      return results;
    }

    private void fetchmatchingPrefixStr(Trie node, List<String> results) {
      if (node.isEnd()) {
        results.add(node.value);
      }

      if (node.childs.length > 0) {
        for (Trie t : node.childs) {
          if (t == null) {
            continue;
          }
          fetchmatchingPrefixStr(t, results);
        }
      }
    }



  }
}
