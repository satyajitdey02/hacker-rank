package com.skill.test.zalando.customs.tech;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task2 {

    public static void main(String[] args) {
        Task2 task = new Task2();
        int[] input = new int[]{4, 1, 2, 3, -4, 4};
        System.out.println(task.solution(input));
        //System.out.println(Integer.MIN_VALUE);
    }

    public int solution(int[] A) {
        List<Integer> numbers = IntStream.of(A).boxed().sorted().collect(Collectors.toList());
        for (int n : numbers) {
            if (numbers.contains(n) && numbers.contains(n * -1)) {
                return Math.abs(n);
            }
        }

        return 0;
    }
}
