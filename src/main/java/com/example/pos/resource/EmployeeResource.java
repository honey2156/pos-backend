package com.example.pos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.constants.ResourceConstants;
import com.example.pos.model.Employee;
import com.example.pos.service.EmployeeService;

/**
 * Controller that handles Employee requests
 * 
 * @author mandeepsingh
 *
 */
@RestController
@RequestMapping(value = ResourceConstants.EMPLOYEE_BASE)
@CrossOrigin(origins = { "http://localhost:4200" })
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Get all employees
	 * 
	 * @return
	 */
	@GetMapping
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}

	/**
	 * Seed employees
	 */
	@GetMapping(value = ResourceConstants.EMPLOYEE_SEED)
	public void seedEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			employees.add(new Employee("employee" + i, "employee" + i, "emp" + i, "employee" + i + "@email.com",
					"1234567891"));
		}
		employeeService.seedEmployees(employees);
	}

	/**
	 * Handles login authentication of employee
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping(value = ResourceConstants.EMPLOYEE_LOGIN)
	public Employee login(@RequestBody Employee employee) {
		return employeeService.login(employee.getUsername(), employee.getPassword());
	}
}
