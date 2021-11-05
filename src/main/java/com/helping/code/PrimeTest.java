package com.helping.code;

public class PrimeTest {
    public static void main(String[] args) {
        System.out.println(isPrimeAlt(0));
        System.out.println(isPrimeAlt(1));
        System.out.println(isPrimeAlt(2));
        System.out.println(isPrimeAlt(13));
        System.out.println(isPrimeAlt(16));
        System.out.println(isPrimeAlt(7));
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        if(num == 2) {
            return true;
        }

        for (int i = 2; i < num / 2; i++) {
            if((num % i) == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPrimeAlt(int num) {
        if (num <= 1) {
            return false;
        }



        for (int i = 2; i < Math.sqrt(num); i++) {
            if((num % i) == 0) {
                return false;
            }
        }

        return true;
    }
}
