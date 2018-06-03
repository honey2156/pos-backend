package com.example.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.EmployeeDao;
import com.example.pos.model.Employee;
import com.example.pos.service.EmployeeService;

/**
 * @author mandeepsingh
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.EmployeeService#getAllEmployees()
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.EmployeeService#seedEmployees(java.util.List)
	 */
	@Override
	public void seedEmployees(List<Employee> seededEmployees) {
		employeeDao.saveAll(seededEmployees);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.EmployeeService#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Employee login(String username, String password) {
		// Find employee by username and match password
		Employee employee = employeeDao.findByUsername(username);
		if (employee != null && password.equals(employee.getPassword())) {
			return employee;
		} else
			return null;
	}

}
