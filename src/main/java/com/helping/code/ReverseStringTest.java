package com.helping.code;

public class ReverseStringTest {
    public static void main(String[] args) {
        String name = "Satyajit Dey";
//        char[] chars = name.toCharArray();
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = chars.length - 1; i>=0; i--) {
//            sb.append(chars[i]);
//        }

        StringBuilder sb = new StringBuilder(name);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
