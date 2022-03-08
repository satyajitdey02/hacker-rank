package com.skill.test.een;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NthLowestSale {
    public static int nthLowestSelling(int[] sales, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int sale : sales) {
            if (map.containsKey(sale)) {
                map.put(sale, map.get(sale) + 1);
            } else {
                map.put(sale, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        return entryList.get(n-1).getKey();
    }

    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 5, 2, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5, 5 }, 3);
        System.out.println(x);
    }
}
