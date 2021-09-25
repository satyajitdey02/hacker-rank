package com.helping.code;

import java.util.Arrays;

public class DistanceBetweenClosestNumber {
    // Returns the distance between the two closest numbers.
    static int distClosestNumbers(int[] numbers) {
        // try to implement it!
        Arrays.sort(numbers);

        int a, b;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            a = numbers[i];
            b = numbers[i + 1];

            if ((b - a) < diff) {
                diff = b - a;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 9, 50, 15, 90, 7, 98, 65};
        int result = distClosestNumbers(testArray);
        System.out.println(result); // Expected result is 1 (the 2 closest numbers are 98 and 99)
    }
}
