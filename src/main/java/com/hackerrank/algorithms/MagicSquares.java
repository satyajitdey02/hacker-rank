package com.hackerrank.algorithms;

import java.util.Arrays;
import java.util.List;

public class MagicSquares {

    //    5 3 4
    //    1 5 8
    //    6 4 2

    public static void main(String[] args) {
        System.out.println(formingMagicSquare(Arrays.asList(
//                7 6 5 -> 3
//                7 2 8 -> 2
//                5 3 4 ->

//                7 6 2 -> 3
//                5 2 8 -> 2
//                5 3 4 ->
//                    Arrays.asList(8, 3, 4),
//                    Arrays.asList(1, 5, 9),
//                    Arrays.asList(6, 7, 2)
//                Arrays.asList(5, 3, 4),
//                Arrays.asList(1, 5, 8),
//                Arrays.asList(6, 4, 2)
//                Arrays.asList(4, 9, 2),
//                Arrays.asList(3, 5, 7),
//                Arrays.asList(8, 1, 5)

                Arrays.asList(4, 8, 2),
                Arrays.asList(4, 5, 7),
                Arrays.asList(6, 1, 6)
        )));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        int totalCost = 0;
        for(List<Integer> list : s) {
            int sum = Integer.sum(list.get(0), Integer.sum(list.get(1), list.get(2)));
            if(sum != 15) {
                int diffs = Math.abs(15 - sum);
                //int max = Integer.max(list.get(0), Integer.max(list.get(1), list.get(2)));
                totalCost += diffs;
            }
        }

        return totalCost;
    }

}
