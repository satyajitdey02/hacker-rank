package com.skill.test.zalando.hiring.sprint;

public class Task3 {

    static int solution(int[] A, int K) {
        int n = A.length;
        if(K == n) return n;
        int best = 0;
        int count = 0;
        for (int i = 0; i < n - K - 1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 0;
            if (count > best)
                best = count;
        }
        int result = best + 1 + K;

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(solution(new int[] {1,1,3,3,3,4,5,5,5,5}, 10));
       System.out.println(solution(new int[] {1,1,3,3,3,3,4,5,5,5,5}, 6));
    }
}
