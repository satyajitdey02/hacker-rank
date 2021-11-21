package com.practice.stream;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class StreamPuzzleTest {

	@Test
	public void countOccurrenceOfWordsFromString() {
		String str = "welcome to decode code and code decode welcome you";
		Map<String, Long> occurrence = Stream.of(str.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), counting()));
		System.out.println(occurrence);
	}
}
