package com.practice.stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

//Example Refs: https://stackify.com/streams-guide-java-8/
public class StreamOperationsTest {

	private static Employee[] arrayOfEmps = {
			new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0)
	};

	private static List<Employee> empList = Arrays.asList(arrayOfEmps);
	private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	@Test
	@DisplayName("whenIncrementSalaryForEachEmployee_thenApplyNewSalary")
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
		empList.stream().forEach(e -> e.salaryIncrement(10));

		assertThat(empList, contains(
				hasProperty("salary", equalTo(110000.0)),
				hasProperty("salary", equalTo(220000.0)),
				hasProperty("salary", equalTo(330000.0))
		));
	}

	@Test
	@DisplayName("whenMapIdToEmployees_thenGetEmployeeStream")
	public void whenMapIdToEmployees_thenGetEmployeeStream() {
		Integer[] empIds = {1, 2, 3};
		List<Employee> employees = Stream.of(empIds).map(id -> employeeRepository.findById(id)).collect(Collectors.toList());
		//assertEquals(employees.size(), empList.size());
		assertEquals(employees, empList);
	}

	@Test
	public void whenFilterEmployees_thenGetFilteredStream() {
		List<Employee> employees = Arrays.asList(1, 2, 3, 4, 5).stream()
				.map(id -> employeeRepository.findById(id))
				.filter(Objects::nonNull)
				.filter(e -> e.getSalary() > 200000)
				.collect(Collectors.toList());
		assertEquals(2, employees.size());
	}

	@Test
	public void whenFindFirst_thenGetFirstEmployeeInStream() {
		Employee employee = empList.stream()
				.filter(e -> e.getSalary() > 100000)
				.findFirst().orElse(null);
		assertEquals(employee.getSalary(), new Double(200000));
	}

	@Test
	public void whenStreamToArray_thenGetArray() {
		Employee[] employees = empList.stream().toArray(Employee[]::new);
		assertThat(employees, equalTo(empList.toArray()));
	}

	@Test
	@DisplayName("Count terminal operation test")
	public void whenStreamCount_thenGetElementCount() {
		Long empCount = empList.stream()
				.filter(e -> e.getSalary() > 100000)
				.count();

		assertEquals(empCount, new Long(2));
	}

	@Test
	public void whenLimitInfiniteStream_thenGetFiniteElements() {
		Integer sum = Stream.iterate(1, i -> i + 1)
				//.skip(0)
				.limit(10).reduce(0, Integer::sum);
		assertEquals(55, sum);
	}

	@Test
	public void whenSortStream_thenGetSortedStream() {
		List<Employee> employees = empList.stream()
				.sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		assertEquals(employees.get(0).getName(), "Bill Gates");
		assertEquals(employees.get(1).getName(), "Jeff Bezos");
		assertEquals(employees.get(2).getName(), "Mark Zuckerberg");
	}

	@Test
	public void whenFindMin_thenGetMinElementFromStream() {
		Employee minSalary = empList.stream()
				.min(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException::new);
		assert minSalary != null;
		assertEquals(100000.0, new Double(minSalary.getSalary()));
	}

	@Test
	public void whenFindMax_thenGetMaxElementFromStream() {
		Employee maxSalary = empList.stream()
				.max(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException::new);

		assertEquals(300000.0, new Double(maxSalary.getSalary()));
	}

	@Test
	public void whenApplyDistinct_thenRemoveDuplicatesFromStream() {
		List<Integer> intList = Arrays.asList(2, 3, 4, 2, 4, 1, 5, 7, 9, 4);
		List<Integer> distinctIntList = intList.stream().distinct().sorted().collect(Collectors.toList());

		assertEquals(distinctIntList, Arrays.asList(1, 2, 3, 4, 5, 7, 9));
	}

	@Test
	public void whenApplyMatch_thenReturnBoolean() {
		List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

		boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
		boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
		boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

		assertFalse(allEven);
		assertTrue(oneEven);
		assertFalse(noneMultipleOfThree);
	}

	@Test
	public void whenFindMaxOnIntStream_thenGetMaxInteger() {
		int maxId = empList.stream()
				.mapToInt(Employee::getId)
				.max()
				.orElseThrow(NoSuchElementException::new);
		assertEquals(3, maxId);
	}

	@Test
	public void whenApplySumOnIntStream_thenGetSum() {
		Double avgSal = empList.stream().mapToDouble(Employee::getSalary).average().orElseThrow(NoSuchElementException::new);
		assertEquals(Double.valueOf(200000), avgSal);
	}

	@Test
	public void whenApplyReduceOnStream_thenGetValue() {
		Double totalSal = empList.stream().mapToDouble(Employee::getSalary)
				.reduce(0.0, Double::sum);
		assertEquals(Double.valueOf(600000), totalSal);
	}

	@Test
	public void whenCollectByJoining_thenGetJoinedString() {
		String joinedNames = empList.stream().map(Employee::getName).collect(Collectors.joining(", "));
		System.out.println(joinedNames);
		assertEquals(joinedNames, "Jeff Bezos, Bill Gates, Mark Zuckerberg");
	}

	@Test
	public void whenCollectBySet_thenGetSet() {
		Set<String> empNames = empList.stream()
				.map(Employee::getName)
				.collect(Collectors.toSet());

		assertEquals(empNames.size(), 3);
	}

	@Test
	public void whenApplySummarizing_thenGetBasicStats() {
		DoubleSummaryStatistics stats = empList.stream()//.mapToDouble(Employee::getSalary)
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		assertEquals(3, stats.getCount());
		assertEquals(Double.valueOf(200000), stats.getAverage());
		assertEquals(Double.valueOf(300000), stats.getMax());
		assertEquals(Double.valueOf(100000), stats.getMin());
		assertEquals(Double.valueOf(600000), stats.getSum());
	}

	@Test
	public void whenApplySummaryStatistics_thenGetBasicStats() {
		DoubleSummaryStatistics stats = empList.stream()
				.mapToDouble(Employee::getSalary)
				.summaryStatistics();

		assertEquals(stats.getCount(), 3);
		assertEquals(stats.getSum(), 600000.0, 0);
		assertEquals(stats.getMin(), 100000.0, 0);
		assertEquals(stats.getMax(), 300000.0, 0);
		assertEquals(stats.getAverage(), 200000.0, 0);
	}

	@Test
	public void whenStreamPartition_thenGetMap() {
		List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
		Map<Boolean, List<Integer>> isEven = intList.stream().collect(
				Collectors.partitioningBy(i -> i % 2 == 0));

		assertEquals(isEven.get(true).size(), 4);
		assertEquals(isEven.get(false).size(), 1);
	}

	@Test
	public void whenStreamGroupingBy_thenGetMap() {
		Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
				Collectors.groupingBy(e -> e.getName().charAt(0)));

		assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
		assertEquals(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
		assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
	}
}
