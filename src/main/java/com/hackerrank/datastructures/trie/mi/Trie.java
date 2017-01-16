package com.hackerrank.datastructures.trie.mi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 1/16/17.
 */
//TODO: add new field value:String to Trie Class
public class Trie {
  char ch;
  Trie[] childs = new Trie[26];
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
    if (childs == null || childs.length <=0 ) {
      return false;
    }

    return childs[ch - 'a'] != null;
  }

  public void insert(String str) {
    char[] chars = str.toCharArray();
    Trie trie = this;
    for (char c : chars) {
      Trie newChild;
      if (!trie.containsKey(c)) {
        newChild = new Trie(c);
        trie.childs[c-'a'] = newChild;
      }

      trie = trie.childs[c-'a'];
    }

    trie.setEnd();
  }

  public List<String> search(String word) {
    List<String> results = new ArrayList<String>();
    char[] searchChars = word.toLowerCase().toCharArray();
    Trie matchingNode = this;
    boolean matched=false;
    for(char c: searchChars) {
      //Trie[] nodes = this.childs;
      matchingNode = matchingNode.childs[c-'a'];
      if(matchingNode!=null) {
        matched = true;
        continue;
      } else {
        matched = false;
        break;
      }

    }
results.add(word);
   // while ()
    return results;


  }

  public void print(Trie node) {
    System.out.print(node.ch + "-->");
    /*System.out.println(" |");
    System.out.println(" |");
    if (node.isEnd()) {
      System.out.println("{E}");
      return;
    }*/

    if (node.childs != null && node.childs.length > 0) {
      for (Trie t : node.childs) {
        if(t==null) {
          continue;
        }
        print(t);
      }
    }
  }

  public static void main(String[] args) {
    Trie trie = createRoot();
    trie.insert("tea");
    trie.insert("teach");
    trie.insert("teacher");
    trie.print(trie);
  }

}
