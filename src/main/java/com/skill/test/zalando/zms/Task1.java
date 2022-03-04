package com.skill.test.zalando.zms;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        Task1 task = new Task1();
        System.out.println(task.solution("hellaaobbbcccc"));

    }

    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = IntStream.of(occurrences).max().orElse(0);

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                return Character.toString((char)((int)'a' + i));
            }
        }

        return Character.toString(best_char);
    }
}
