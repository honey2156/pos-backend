package com.example.pos.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.Employee;

/**
 * @author mandeepsingh
 *
 */
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

	/**
	 * Find Employee by employee id
	 * 
	 * @param id
	 * @return
	 */
	public Employee findById(int id);

	/**
	 * Find Employee by username
	 * 
	 * @param username
	 * @return
	 */
	public Employee findByUsername(String username);
}
