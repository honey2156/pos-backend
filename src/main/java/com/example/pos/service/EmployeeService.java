package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();

	public void seedEmployees(List<Employee> seededEmployees);
}
