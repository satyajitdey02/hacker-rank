package com.skill.test.een;

import java.util.HashMap;
import java.util.Map;

public class CountNonZeroChildParents {

    public static int count(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tree) {
            map.put(n, 1);
        }

        return map.entrySet().size() - 1;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 3, 1, -1, 3}));
    }
}
