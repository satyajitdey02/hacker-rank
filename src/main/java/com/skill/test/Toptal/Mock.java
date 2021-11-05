package com.skill.test.Toptal;

import java.util.*;

public class Mock {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));
    }

    public static int solution(int[] A) {
        List<Integer> nums = new ArrayList<>();
        int sum = 0;
        for(int n : A) {
            if(n > 0 && !nums.contains(n)) {
                nums.add(n);
                sum += n;
            }
        }

        if(sum <= 0) return 1;
        Collections.sort(nums);
        int expResult = nums.get(nums.size()-1) * (nums.get(nums.size()-1)+ 1) / 2;
        if(sum == expResult) {
            return nums.get(nums.size()-1) + 1;
        } else {
            return expResult - sum;
        }
    }
}
