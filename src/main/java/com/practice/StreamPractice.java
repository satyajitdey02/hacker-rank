package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream().flatMap(Collection::stream).sorted().collect(Collectors.toList());
        phones.forEach(System.out::println);

//        int min = Arrays.stream(new int[]{1, 2, 3, 4, -1, 0}).min().orElse(0) ;
//        System.out.println(min);
//
//        min = Arrays.stream(new int[]{}).min().orElse(0);
//        System.out.println(min);


//        Function<Integer, Integer> func = x -> x * 2;
//        System.out.println(func.apply(2));
//
//        BiFunction<Integer, Integer, Integer> biFunc = (x1, x2) -> x1 + x2;
//        int result = biFunc.apply(1, 2);
//        System.out.println(result);


//        Thread thread = new Thread(() -> System.out.println("Hello"));
//        thread.start();

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Collections.sort(list);
//        int sum = list.stream().reduce(0, Integer::sum);
//        System.out.println(sum);
    }


    public static void sortAsc() {

        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");

        /*
		List<String> sortedList = list.stream()
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList());

        List<String> sortedList = list.stream()
			.sorted((o1,o2)-> o1.compareTo(o2))
			.collect(Collectors.toList());
		*/

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());

        sortedList.forEach(System.out::println);

    }

    public static void sortDesc() {

        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");

        /*
		List<String> sortedList = list.stream()
			.sorted((o1,o2)-> o2.compareTo(o1))
			.collect(Collectors.toList());
		*/

        List<String> sortedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);

    }
}
