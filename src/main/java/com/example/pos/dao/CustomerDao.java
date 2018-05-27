package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

	public Customer findByName(String name);

	public Customer findById(int id);

	public Customer findByEmail(String email);

	public Customer findByNumber(String number);

	@Query("select c from Customer c where CONCAT(c.id, '') like ?1% or c.name like %?2% or c.email like %?3% or c.number like ?4%")
	public List<Customer> searchCustomers(String searchById, String searchByName, String searchByEmail,	String searchByNumber);
}
