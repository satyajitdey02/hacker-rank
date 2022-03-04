package com.skill.test.een;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static int nthLowestSelling(int[] sales, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sales.length; i++) {
            if (map.containsKey(sales[i])) {
                map.put(sales[i], map.get(sales[i]) + 1);
            } else {
                map.put(sales[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);


        return list.get(n-1);
    }

    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 5,  2, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5, 5 }, 2);
        System.out.println(x);
    }
}
