package com.hackerrank.datastructures.trie.mi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 1/16/17.
 */
public class Trie {
  char ch;
  List<Trie> childs = new ArrayList<Trie>();
  boolean end;

  public Trie(char ch) {
    this.ch = ch;
  }

  public static Trie createRoot() {
    return new Trie('0');
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd() {
    this.end = true;
  }

  private boolean containsKey(char ch) {
    if(childs==null || childs.isEmpty()) {
      return false;
    }

    return childs.get(ch - 'a') != null;
  }

  public void insert(String str) {
    char[] chars = str.toCharArray();
    Trie trie = this;
    for (char c : chars) {
      Trie newChild = null;
      if (!trie.containsKey(c)) {
        newChild = new Trie(c);
        trie.childs.add(newChild);
      }

      trie = newChild;
    }

    trie.setEnd();
  }

  public void print() {
    Trie trie =  this;
    System.out.println(trie.ch);
    System.out.println(" |");
    System.out.println(" |");
    if (trie.isEnd()) {
      System.out.println("{E}");
      return;
    }

    List<Trie> rootChilds = trie.childs;
    if (!rootChilds.isEmpty()) {
      for (Trie t : rootChilds) {
        trie = t;
        print();
      }
    }
  }

  public static void main(String[] args) {
    Trie trie = createRoot();
    trie.insert("satyajit");
    trie.print();
  }

}
