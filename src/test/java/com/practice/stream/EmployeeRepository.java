package com.practice.stream;

import java.util.List;

public class EmployeeRepository {
	private List<Employee> empList;

	public EmployeeRepository(List<Employee> empList) {
		this.empList = empList;
	}

	public Employee findById(int id) {
		for (Employee e : empList) {
			if (e.getId() == id) {
				return e;
			}
		}

		return null;
	}
}
