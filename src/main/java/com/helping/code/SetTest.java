package com.helping.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>(Arrays.asList(0, 1, 3, 5,7));
        Set<Integer> setB = new HashSet<>(Arrays.asList(0, 2, 4, 6,8));

        //setA.retainAll(new HashSet<>(Arrays.asList(0, 2, 4, 6,8)));
        //setA.forEach(System.out::println);

        setA.addAll(new HashSet<>(Arrays.asList(0, 2, 4, 6,8)));
        setA.forEach(System.out::println);
    }
}
