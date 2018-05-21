package com.example.pos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

	public Customer findByName(String name);

	public Customer findById(int id);

	public Customer findByEmail(String email);

	public Customer findByNumber(String number);
}
