package com.practice;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrianglePrinter {
	public static void main(String[] args) {
		printTriangle(4);
		printTriangleAlt(4);
	}

	private static void printTriangle(int depth) {
        long start = System.nanoTime();
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
        long stop = System.nanoTime();
        System.out.println("Exe time: " + (stop - start));
	}

	private static void printTriangleAlt(int depth) {
        long start = System.nanoTime();
		for (int i = 1; i <= depth; i++) {

			// loop to print the number of spaces before the star
			for (int j = depth; j >= i; j--) {
				System.out.print(" ");
			}

			// loop to print the number of stars in each row
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}

			// for new line after printing each row
			System.out.println();
		}
        long stop = System.nanoTime();
        System.out.println("Exe time: " + (stop - start));
	}
}
