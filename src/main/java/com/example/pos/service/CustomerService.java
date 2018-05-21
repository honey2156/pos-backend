package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(int customerId);
	
	public Customer getCustomerByName(String customerName);
	
	public Customer getCustomerByEmail(String customerEmail);
	
	public Customer getCustomerByNumber(String customerNumber);
	
	public void seedCustomers(List<Customer> seededCustomers);
}
