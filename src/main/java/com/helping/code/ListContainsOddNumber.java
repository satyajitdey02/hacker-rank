package com.helping.code;

import java.util.Arrays;
import java.util.List;

public class ListContainsOddNumber {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,13,6);
//        for(int n : nums) {
//            if(n % 2 !=0) {
//                System.out.println("Yes");
//                return;
//            }
//        }

        boolean isContainsOdd = nums.stream().anyMatch(x -> x%2 !=0);

        System.out.println(isContainsOdd ? "Yes" : "No");
    }
}
