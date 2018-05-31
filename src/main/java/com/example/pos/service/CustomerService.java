package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Customer;

/**
 * @author mandeepsingh
 *
 */
public interface CustomerService {

	/**
	 * Get all customers
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomers();

	/**
	 * Get customer by customer id
	 * 
	 * @param customerId
	 * @return
	 */
	public Customer getCustomerById(int customerId);

	/**
	 * Get customer by customer name
	 * 
	 * @param customerName
	 * @return
	 */
	public Customer getCustomerByName(String customerName);

	/**
	 * Get customer by customer email
	 * 
	 * @param customerEmail
	 * @return
	 */
	public Customer getCustomerByEmail(String customerEmail);

	/**
	 * Get customer by customer phone number
	 * 
	 * @param customerNumber
	 * @return
	 */
	public Customer getCustomerByNumber(String customerNumber);

	/**
	 * Search customers with search pattern
	 * 
	 * @param searchPattern
	 * @return
	 */
	public List<Customer> searchCustomers(String searchPattern);

	/**
	 * Seed customers
	 * 
	 * @param seededCustomers
	 */
	public void seedCustomers(List<Customer> seededCustomers);
}
