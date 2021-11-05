package com.hackerrank.interview.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayQuadruplet {
    static int[] findArrayQuadruplet(int[] arr, int s) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        if(arr[0] >= s) return new int[] {};

        for(int i=0;i<arr.length;) {
            int sum = arr[i] + arr[i + 1] + arr[i + 2] + arr[i + 3];
            if(sum == s) {
                return new int[]{arr[i], arr[i + 1], arr[i + 2], arr[i + 3]};
            }


        }


        int[] resultArr = new int[result.size()];

        return resultArr;
    }

    public static void main(String[] args) {

    }
}
