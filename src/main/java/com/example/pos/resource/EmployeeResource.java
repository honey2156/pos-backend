package com.example.pos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.model.Employee;
import com.example.pos.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}

	@GetMapping(value = "/seed")
	public void seedEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			employees.add(new Employee("employee" + i, "employee" + i, "emp" + i, "employee" + i + "@email.com",
					"1234567891"));
		}
		employeeService.seedEmployees(employees);
	}
}
