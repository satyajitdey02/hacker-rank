package com.hackerrank.interview.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLeftRotation {
    public static void main(String[] args) {
        System.out.println(rotLeft(Arrays.asList(1,2,3,4,5), 4));
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        List<Integer> result = new ArrayList<>();
        for(int j = d;j<a.size();j++) {
            result.add(a.get(j));
        }

        for (int i = 0; i < d; i++) {
            result.add(a.get(i));
        }

        return result;
    }
}
