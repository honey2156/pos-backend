package com.example.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.EmployeeDao;
import com.example.pos.model.Employee;
import com.example.pos.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	public void seedEmployees(List<Employee> seededEmployees) {
		employeeDao.saveAll(seededEmployees);
	}

	@Override
	public Employee login(String username, String password) {
		Employee employee = employeeDao.findByUsername(username);
		if (employee != null && password.equals(employee.getPassword())) {
			return employee;
		} else
			return null;
	}

}
