package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Employee;

/**
 * @author mandeepsingh
 *
 */
public interface EmployeeService {

	/**
	 * Get all employees
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees();

	/**
	 * Seed employees
	 * 
	 * @param seededEmployees
	 */
	public void seedEmployees(List<Employee> seededEmployees);

	/**
	 * Login employee
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Employee login(String username, String password);
}
