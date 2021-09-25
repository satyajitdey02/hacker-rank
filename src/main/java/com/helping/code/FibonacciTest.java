package com.helping.code;

public class FibonacciTest {
    public static void main(String[] args) {
        //System.out.print(fibonacci(10) + ", ");
        printFibonacciSeries(10);
    }

    private static int fibonacci(int n) {
        return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void printFibonacciSeries(int count) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 1; i <= count; i++) {
            System.out.print(a + " ");
            a = b;
            b = c;
            c = a + b;
        }
    }
}
