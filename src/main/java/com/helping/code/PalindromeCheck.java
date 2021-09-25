package com.helping.code;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "aeiia";

        for(int i=0;i < str.length()/2;i++) {
            if(str.charAt(i) != str.charAt(str.length()-(i+1))) {
                System.out.println("NOT");
                return;
            }
        }

        System.out.println("YES");
    }
}
