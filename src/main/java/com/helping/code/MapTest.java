package com.helping.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> employees = new HashMap<>();
        employees.put("Satyajit", 36);
        employees.put("Keya", 30);
        employees.put("Kuhu", 6);
        employees.put("Dridha", 1);

//        for(Map.Entry<String, Integer> entry : employees.entrySet()) {
//            System.out.println(String.format("%s %d", entry.getKey(), entry.getValue()));
//        }

        List<String> empnames = employees.keySet().stream().sorted(String::compareTo).collect(Collectors.toList());
        empnames.forEach(System.out::println);
        //employees.values().forEach(System.out::println);
    }
}
