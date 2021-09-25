package com.helping.code;

public class SwapNumberTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        b = b + a;
        a = b - a;
        b = b - a;

        System.out.println(a + " " + b);
    }
}
