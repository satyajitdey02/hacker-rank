package com.skill.test.zalando.customs.tech;

public class Task1 {

    public static void main(String[] args) {

        Task1 task = new Task1();
        System.out.println(task.solution(28));
        System.out.println(task.solution(734));
        System.out.println(task.solution(1990));
        System.out.println(task.solution(1000));
        System.out.println(task.solution(50000));
    }

    public int solution(int N) {
        String nStr = String.valueOf(N);
        if (nStr.length() == 1) return N;

        int initSum = nSum(N);
        for (int i = N + 1; i <= 500000; i++) {
            int sum = nSum(i);
            if (sum == initSum) {
                return i;
            }
        }

        return N;
    }

    private int nSum(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int nSum = 0;
        for (Character c : chars) {
            nSum += (c - 48);
        }

        return nSum;
    }
}
