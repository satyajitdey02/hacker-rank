package com.hackerrank.datastructures.queues;

import com.hackerrank.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyajit on 1/21/17.
 */
public class FactorsTree {
  int value;
  int depth;
  List<FactorsTree> nodes = new ArrayList<>();
  
  /*public FactorsTree(int value) {
    new FactorsTree(value, 0);
  }*/

  public FactorsTree(int value, int depth) {
    this.value = value;
    this.depth = depth;
    if (this.value == 0) {
      return;
    }

    if (this.value == 1) {
      FactorsTree tree = new FactorsTree(0, this.depth + 1);
      this.nodes.add(tree);
      return;
    }

    if (this.value == 2) {
      FactorsTree tree = new FactorsTree(1, this.depth + 1);
      this.nodes.add(tree);
      return;
    }

    if (this.value == 3) {
      FactorsTree tree = new FactorsTree(2, this.depth + 1);
      this.nodes.add(tree);
      return;
    }

    if (isPrime(this.value)) {
      FactorsTree tree = new FactorsTree(this.value - 1, this.depth + 1);
      this.nodes.add(tree);
      return;
    }

    for (int i = 2; i * i <= this.value; i++) {
      if (this.value % i == 0) {
        FactorsTree tree = new FactorsTree(Math.max(i, this.value / i), this.depth + 1);
        this.nodes.add(tree);
      }
    }

    FactorsTree tree = new FactorsTree(this.value - 1, this.depth + 1);
    this.nodes.add(tree);
  }

  public List<FactorsTree> getLeafNodes() {
    List<FactorsTree> leafNodes = new ArrayList<>();
    if (this.nodes.isEmpty()) {
      leafNodes.add(this);
    } else {
      for (FactorsTree node : this.nodes) {
        leafNodes.addAll(node.getLeafNodes());
      }
    }
    return leafNodes;
  }

  public int minDownToZeroSteps() {
    int result = Integer.MAX_VALUE;
    for (FactorsTree tree : getLeafNodes()) {
      if (tree.depth < result) {
        result = tree.depth;
      }
    }

    return result;
  }

  private boolean isPrime(int number) {
    if (number == 1) {
      return false;
    }
    if (number == 2) {
      return true;
    }

    if (number % 2 == 0) {
      return false;
    }

    for (int i = 3; i * i < number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }

}
