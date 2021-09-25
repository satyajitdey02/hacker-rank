package com.helping.code;

import java.util.*;
import java.util.stream.Collectors;

public class SortTest {
    public static void main(String[] args) {
        String[] names = new String[] {"Satyajit", "Keya", "Kuhu", "Dridha", "Ma", "Baba"};
        List<String> nameList = Arrays.asList(names);
        nameList.sort(Comparator.comparing(String::toString));
        //Collections.sort(nameList);
        //nameList = nameList.stream().sorted(String::compareTo).collect(Collectors.toList());

        nameList.forEach(System.out::println);
    }
}
