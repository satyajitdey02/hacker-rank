package com.hackerrank.interview.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(11, 2, 4));
        matrix.add(Arrays.asList(4, 5, 6));
        matrix.add(Arrays.asList(10, 8, -12));

        System.out.println(diagonalDifference(matrix));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int dlr = 0, drl = 0;

        int j = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            dlr += arr.get(i).get(i);
            drl += arr.get(i).get(j);
            j--;
        }

        return Math.abs(dlr - drl);
    }
}
