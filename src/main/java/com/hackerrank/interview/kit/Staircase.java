package com.hackerrank.interview.kit;

public class Staircase {

    public static void main(String[] args) {
        staircase(25);
    }

    public static void staircase(int n) {
        StringBuilder sb = new StringBuilder();
        StringBuilder spacesSb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("#");
            spacesSb.append(" ");
        }


        for (int i = n-1; i >= 0; i--) {
            String substring = sb.toString().substring((i),  n);
            System.out.println((spacesSb.toString().substring(0, i) + substring));
        }

    }

    public static String twoStrings(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s2.indexOf(s1.charAt(i)) >= 0) {
                return "YES";
            }
        }
        return "NO";
    }

}
