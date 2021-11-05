package com.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrianglePrinter {
    public static void main(String[] args) {
        printTriangle(4);
        printTriangle(5);
    }

    private static void printTriangle(int depth) {
        int startPos = depth;
        int stopPos = depth;
        StringBuilder sb = new StringBuilder(IntStream.rangeClosed(1, (2 * depth) + 1).mapToObj(index -> " ").collect(Collectors.joining()));
        for (int i = 0; i < depth; i++) {
            String stars = IntStream.rangeClosed(1, (2 * i) + 1).mapToObj(index -> "*").collect(Collectors.joining());
            sb.replace(startPos, stopPos, stars);
            System.out.println(sb.toString());
            startPos--;
            stopPos++;
        }
    }
}
