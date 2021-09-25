package com.helping.code;

public class SubstringTest {
    public static void main(String[] args) {
        String name = "Satyajit Dey";
        String firstName = name.substring(0, name.indexOf(' '));
        System.out.println("firstName = " + firstName);

        String lastName = name.substring(name.indexOf(' ') + 1, name.length());
        System.out.println("lastName = " + lastName);
    }
}
