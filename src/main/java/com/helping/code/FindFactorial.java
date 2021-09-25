package com.helping.code;

public class FindFactorial {
    public static void main(String[] args) {
        //System.out.println(factorial(5));

        String trim = "   sfsd sfs   \t".trim();
        //System.out.printf("[%s]", trim);
        String replaced = "  satyajit dey ".replaceAll("\\s", "");
        System.out.printf("[%s]", replaced);
    }

    private static int factorial(int n) {
        if (n ==1) return 1;

        return n * factorial(n-1);
    }
}
