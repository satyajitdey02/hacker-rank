package com.hackerrank.interview.kit;

import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void main(String[] args) {
        plusMinus(Arrays.asList(1, 1, 0, -1, -1));
    }

    public static void plusMinus(List<Integer> arr) {
        int posVal = 0;
        int negVal = 0;
        int zeroVal = 0;

        for (int n : arr) {
            if (n < 0) {
                negVal++;
            } else if (n > 0) {
                posVal++;
            } else {
                zeroVal++;
            }
        }

        double posRatio = posVal / (double) arr.size();
        System.out.println(String.format("%.6f", posRatio));
        double negRatio = negVal / (double) arr.size();
        System.out.println(String.format("%.6f", negRatio));
        double zeroRatio = zeroVal / (double) arr.size();
        System.out.println(String.format("%.6f", zeroRatio));
    }
}
