package com.skill.test.een;

import java.util.Stack;
import java.util.stream.Collectors;

public class WheelDefects {
    public static String simplify(String input) {
        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()) {
            if(stack.isEmpty() ) {
                stack.push(ch);
                continue;
            }

            if(stack.peek() != ch) {
                stack.push(ch);
            }
        }

        return stack.stream().map(c -> Character.toString(c)).collect(Collectors.joining(""));
        //return new StringBuilder( stack.stream().map(c -> Character.toString(c)).collect(Collectors.joining(""))).toString();
    }

    public static void main(String[] args) {
        System.out.println(WheelDefects.simplify("ghhrkkb"));
        //System.out.println(WheelDefects.simplify(" aa "));
    }
}
