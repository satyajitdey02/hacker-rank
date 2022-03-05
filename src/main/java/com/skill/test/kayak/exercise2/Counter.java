package com.skill.test.kayak.exercise2;

import java.util.stream.IntStream;

/**
 * KAYAK EXCERCISE#1: A simple counter solution KAYAK
 */
public class Counter {

    /**
     * <p>Method to count up from {start} to {end}</p>
     * @param start
     * @param end
     *
     */
    public void countUp(int start, int end) {
        IntStream.rangeClosed(start, end).forEach(System.out::println);
    }

    /**
     * <p>Method to count up from {start} to {end} and then count down to {start} again</p>
     * @param start
     * @param end
     */
    public void countUpAndDown(int start, int end) {
        IntStream.rangeClosed(start, (2 * end) - start)
                .map(e -> e <= end ? e : (2 * end - e))
                .forEach(System.out::println);
    }
}
