package com.helping.code;

public class DoubleComparisonTest {
    public static void main(String[] args) {

        double d1 = 1.230d;
        double d2 = 1.231d;

        if(Double.compare(d1, d2) == 0) {
            System.out.println("d1 == d2");
        } else if(Double.compare(d1, d2) < 0) {
            System.out.println("d1 < d2");
        } else {
            System.out.println("d1 > d2");
        }
    }
}
