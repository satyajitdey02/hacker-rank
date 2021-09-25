package com.hackerrank.algorithms;

public class DrawingBook {
    public static void main(String[] args) {
        System.out.println(pageCount(4, 3));
    }

    public static int pageCount(int n, int p) {
        //if (p == 1 || p == n) return 0;
        return n % 2 == 0 ? Integer.min(p / 2, (n - p + 1) / 2): Integer.min(p / 2, (n - p) / 2);
    }
}
