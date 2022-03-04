package com.skill.test.een;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WheelDefects {
    //Set<Integer> targetSet = new HashSet<Integer>(Arrays.asList(sourceArray));

    public static String simplify(String input) {
//        StringBuilder sb = new StringBuilder();
//        char[] chars = input.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if(!sb.toString().contains(String.valueOf(chars[i]))) {
//                sb.append(chars[i]);
//            }
//        }
//        return sb.toString();

        String output = input.chars().distinct().mapToObj(c -> (char)c).map(String::valueOf).collect(Collectors.joining(""));

        return output;
    }

    public static void main(String[] args) {
        System.out.println(WheelDefects.simplify("ghhrkkb"));
        System.out.println(WheelDefects.simplify(" aa "));
    }
}
