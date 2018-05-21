package com.example.pos.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Integer> {

	public Customer findByName(String name);

	public Customer findById(int id);

	public Customer findByEmail(String email);

	public Customer findByNumber(String number);
}
