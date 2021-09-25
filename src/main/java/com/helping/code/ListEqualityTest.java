package com.helping.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEqualityTest {
    public static void main(String[] args) {
        String[] strs = new String[] {"A", "B", "C"};

        List<String> list1 = Arrays.asList(strs);
        List<String> list2 = new ArrayList<>(Arrays.asList(strs));
        List<String> list3 = new ArrayList<String>(Arrays.asList("A", new String("B"), "C"));

        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
    }
}
