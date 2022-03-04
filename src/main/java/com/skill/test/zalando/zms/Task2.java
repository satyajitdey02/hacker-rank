package com.skill.test.zalando.zms;

import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();

        System.out.println(task2.solution("4 5 6 - 7 +"));
        System.out.println(task2.solution("13 DUP 4 POP 5 DUP + DUP + -"));
        System.out.println(task2.solution("5 6 + -"));
        System.out.println(task2.solution("3 DUP 5 - -"));
        System.out.println(task2.solution("1048575 DUP +"));
    }

    public int solution(String S) {
        Stack<Integer> machine = new Stack<>();
        String[] inputParts = S.split("\\s+");
        for (String s : inputParts) {
            if ("POP".equals(s)) {
                machine.pop();
            } else if ("DUP".equals(s)) {
                int topNum = machine.peek();
                machine.push(topNum);
            } else if ("+".equals(s)) {
                if (machine.isEmpty()) {
                    return -1;
                }

                int n1 = machine.pop();
                if (machine.isEmpty()) {
                    return -1;
                }

                int n2 = machine.pop();
                int addition = n1 + n2;

                if (addition > 1048575) {
                    return -1;
                }
                machine.push(addition);
            } else if ("-".equals(s)) {
                if (machine.isEmpty()) {
                    return -1;
                }

                int n1 = machine.pop();
                if (machine.isEmpty()) {
                    return -1;
                }

                int n2 = machine.pop();
                int subtraction = n1 - n2;

                if (subtraction < 0) {
                    return -1;
                }
                machine.push(subtraction);
            } else {
                machine.push(Integer.parseInt(s));
            }
        }

        if (machine.isEmpty()) {
            return -1;
        }

        return machine.pop();
    }

}
