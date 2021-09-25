package com.helping.code;

public class CamelCaseTest {
    public static void main(String[] args) {
        String str = "findEmployeeByName";

        char[] chars = str.toCharArray();

        int capLetter = 0;
        for(char ch : chars) {
            if(Character.isUpperCase(ch)) {
                capLetter++;
            }
        }

        System.out.println(capLetter+1);
    }
}
