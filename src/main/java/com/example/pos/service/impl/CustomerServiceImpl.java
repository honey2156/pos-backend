package com.example.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pos.dao.CustomerDao;
import com.example.pos.model.Customer;
import com.example.pos.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = customerDao.findById(customerId);
		return customer;
	}

	@Override
	public Customer getCustomerByName(String customerName) {
		customerDao.findByName(customerName);
		return null;
	}

	@Override
	public Customer getCustomerByEmail(String customerEmail) {
		return customerDao.findByEmail(customerEmail);
	}

	@Override
	public Customer getCustomerByNumber(String customerNumber) {
		return customerDao.findByNumber(customerNumber);
	}

}
