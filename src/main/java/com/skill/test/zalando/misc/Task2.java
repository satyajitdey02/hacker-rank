package com.skill.test.zalando.misc;

import java.math.BigInteger;

public class Task2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 400000; i++) {
            sb.append("1");
        }

        //System.out.println(new BigInteger(sb.toString(), 2));
        //System.out.println(Long.parseLong(sb.toString(), 2));
        //System.out.println(Integer.parseInt(sb.toString(), 2));
        Task2 task2 = new Task2();
        //System.out.println(task2.minOperations(sb.toString()));
        System.out.println(task2.solution("011100"));
        System.out.println(task2.solution("111"));
        System.out.println(task2.solution("011100"));
    }

    public int solution(String S) {
        int result = 0;
        String trimmedNumber = S.replaceFirst("^0+(?!$)", "");
        //System.out.println(S.length() -trimmedNumber.length() + "--- " + trimmedNumber);
        if (trimmedNumber.length() < 32) {
            int intNum = Integer.parseInt(trimmedNumber, 2);
            if (intNum == 0) {
                return 0;
            }

            while (intNum > 0) {
                if (intNum % 2 == 0) {
                    intNum = intNum / 2;
                } else {
                    intNum = intNum - 1;
                }
                result++;
            }

        } else if (trimmedNumber.length() < 64) {
            long longNum = Long.parseLong(trimmedNumber, 2);
            if (longNum == 0) {
                return 0;
            }

            while (longNum > 0) {
                if (longNum % 2 == 0) {
                    longNum = longNum / 2;
                } else {
                    longNum = longNum - 1;
                }
                result++;
            }
        } else {
            BigInteger bigInteger = new BigInteger(trimmedNumber, 2);
            //return bigIntSteps(bigInteger, 0);
            if (bigInteger.equals(BigInteger.ZERO)) {
                return 0;
            }

            while (bigInteger.compareTo(BigInteger.ONE) > 0) {
                if (bigInteger.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
                    bigInteger = bigInteger.divide(new BigInteger("2"));
                } else if (bigInteger.equals(new BigInteger("3")) || bigInteger.mod(new BigInteger("4")).equals(BigInteger.ONE)) {
                    bigInteger = bigInteger.subtract(new BigInteger("1"));
                } else {
                    bigInteger = bigInteger.add(new BigInteger("1"));
                }
                result++;
            }


//            while (bigInteger.compareTo(BigInteger.ONE) > 0) {
//                if (bigInteger.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
//                    bigInteger = bigInteger.divide(new BigInteger("2"));
//                } else {
//                    bigInteger = bigInteger.subtract(new BigInteger("1"));
//                }
//                result++;
//            }
        }

        return result;
    }

    private int bigIntSteps(BigInteger bigInteger, int steps) {
        if (bigInteger.equals(BigInteger.ZERO)) {
            return 0;
        }

        if (bigInteger.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
            bigInteger = bigInteger.divide(new BigInteger("2"));
        } else {
            bigInteger = bigInteger.subtract(new BigInteger("1"));
        }
        return bigIntSteps(bigInteger, steps + 1);
    }


    private int minOperations(String s) {
        char[] chars = s.toCharArray();

        int result = 0;
        int sign = 1;

        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - 48;
            int power = digit > 0 ? (int) Math.pow(2, s.length() - (i + 1)) : 0;
            int steps = digit * (power * 2 - 1);

            result += steps * sign;
            sign = sign * (digit == 0 ? 1 : -1);
        }

        return result;
    }


}
