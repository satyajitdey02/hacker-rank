package com.skill.test.zalando.zms;

public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        System.out.println(task3.solution("23"));
        System.out.println(task3.solution("0081"));
        System.out.println(task3.solution("022"));
    }

    public int solution(String S) {
        int result = Integer.parseInt(S) % 3 == 0 ? 1 : 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j <= 9; j++) {
                if (S.charAt(i) - 48 != j) {
                    char[] chars = S.toCharArray();
                    chars[i] = (char) (j + 48);
                    int num = Integer.parseInt(String.valueOf(chars));
                    if (num % 3 == 0) {
                        result++;
                    }
                }

            }
        }

        return result;
    }
}
