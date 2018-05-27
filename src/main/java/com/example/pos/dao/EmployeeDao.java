package com.example.pos.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
	public Employee findById(int id);

	public Employee findByUsername(String username);
}
