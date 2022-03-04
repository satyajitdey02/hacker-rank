package com.skill.test.kayak;

import java.util.stream.IntStream;

public class Counter {

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.countUp(0, 5);
        System.out.println("================================================");
        counter.countUpAndDown(3,5);
    }

    //Part-1 Count UP
    void countUp(int start, int end) {
        IntStream.rangeClosed(start, end).forEach(System.out::println);
    }

    //Part-1 Count UP and then Count DOWN
    void countUpAndDown(int start, int end) {
        IntStream.rangeClosed(start, (2 * end) - start)
                .map(e -> e <= end ? e : (2 * end - e))
                .forEach(System.out::println);
    }

}
