package com.hackerrank.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by satyajit on 1/11/17.
 */
public class PoisonousPlants {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    int prevPesticide = Integer.MAX_VALUE;
    List<Plant> plants = new ArrayList<Plant>();
    for (int i = 0; i < N; i++) {
      int curPesticide = in.nextInt();
      if(curPesticide < prevPesticide) {
        plants.add(new Plant(i + 1, curPesticide));
      }
      prevPesticide = curPesticide;
    }

    if(plants.size() == N) {
      System.out.println(0);
      return;
    }

    int round = 1;
    int i=0;
    boolean allOrdered = false;
    prevPesticide = Integer.MAX_VALUE;
    while (!allOrdered) {
      if(plants.size() == 0) {
        System.out.println(round);
        return;
      }

      Plant p1 = plants.get(i);
      if(p1.pesticideAmount > prevPesticide) {
        prevPesticide = p1.pesticideAmount;
        plants.remove(i);
      }
      i++;
      round++;
    }

    in.close();


  }

  static class Plant {
    int plantNumber;
    int pesticideAmount;

    public Plant(int plantNumber, int pesticideAmount) {
      this.plantNumber = plantNumber;
      this.pesticideAmount = pesticideAmount;
    }
  }
}
