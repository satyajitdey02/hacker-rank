package com.hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 * Created by satyajit on 12/27/16.
 */
public class Arrays2D {
    public static void main(String[] args) {
        //int[][] input = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};

        Scanner in = new Scanner(System.in);
        int input[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                input[arr_i][arr_j] = in.nextInt();
            }
        }

        int result = -63;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                int hourGlassVal = input[i - 1][j - 1] + input[i - 1][j] + input[i - 1][j + 1] +
                                                            input[i][j] +
                                    input[i + 1][j - 1] + input[i + 1][j] + input[i + 1][j + 1];

                if(hourGlassVal > result) {
                    result = hourGlassVal;
                }
            }
        }

        System.out.println(result);
    }
}
