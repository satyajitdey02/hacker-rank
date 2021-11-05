package com.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaPractice {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 10);
        List<Integer> intList = intStream.boxed().collect(Collectors.toList());
        intList.forEach(System.out::print);

        int sum = intStream.boxed().mapToInt(i -> i).sum();
        System.out.println(sum);

    }
}
