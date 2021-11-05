package com.skill.test.zalando.hiring.sprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] input = new int[100000];
        Random random = new Random();
        int min = -10;
        int max = 10;
        for(int i=0;i<100000;i++) {
            input[i] = random.nextInt(100) - 10;//(int)Math.floor(Math.random()*(max-min+1)+min);
        }

        //System.out.println(solutionAlt(new int[]{1, -2, -3, 5}));
        System.out.println(solutionAlt(input));
        System.out.println(solutionAlt(input));
    }

    public static int solution(int[] A) {
        long result = 1L;
        for (int n : A) {
            result *= n;
        }

        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int solutionAlt(int[] A) {
        List<Integer> nums = new ArrayList<>();
        int negCount = 0;
        for (int a : A) {
            if (a == 0) return 0;
            if (a < 0) {
                negCount++;
            }

        }

        return negCount % 2 == 0 ? 1 : -1;
    }
}
