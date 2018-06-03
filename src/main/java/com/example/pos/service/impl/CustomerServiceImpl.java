package com.example.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.CustomerDao;
import com.example.pos.model.Customer;
import com.example.pos.service.CustomerService;

/**
 * @author mandeepsingh
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.CustomerService#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.CustomerService#getCustomerById(int)
	 */
	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = customerDao.findById(customerId);
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.CustomerService#getCustomerByName(java.lang.String)
	 */
	@Override
	public Customer getCustomerByName(String customerName) {
		return customerDao.findByName(customerName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.CustomerService#getCustomerByEmail(java.lang.String)
	 */
	@Override
	public Customer getCustomerByEmail(String customerEmail) {
		return customerDao.findByEmail(customerEmail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.CustomerService#getCustomerByNumber(java.lang.String)
	 */
	@Override
	public Customer getCustomerByNumber(String customerNumber) {
		return customerDao.findByNumber(customerNumber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.CustomerService#searchCustomers(java.lang.String)
	 */
	@Override
	public List<Customer> searchCustomers(String searchPattern) {
		return customerDao.searchCustomers(searchPattern, searchPattern, searchPattern, searchPattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.CustomerService#seedCustomers(java.util.List)
	 */
	@Override
	public void seedCustomers(List<Customer> seededCustomers) {
		customerDao.saveAll(seededCustomers);
	}

}
