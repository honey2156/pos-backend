package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.Customer;

/**
 * @author mandeepsingh
 *
 */
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

	/**
	 * Find Customer by customer name
	 * 
	 * @param name
	 * @return
	 */
	public Customer findByName(String name);

	/**
	 * Find Customer by customer id
	 * 
	 * @param id
	 * @return
	 */
	public Customer findById(int id);

	/**
	 * Find Customer by customer email
	 * 
	 * @param email
	 * @return
	 */
	public Customer findByEmail(String email);

	/**
	 * Find Customer by customer phone number
	 * 
	 * @param number
	 * @return
	 */
	public Customer findByNumber(String number);

	/**
	 * Search Customers based on search pattern
	 * 
	 * @param searchById
	 * @param searchByName
	 * @param searchByEmail
	 * @param searchByNumber
	 * @return
	 */
	@Query("select c from Customer c where CONCAT(c.id, '') like ?1% or c.name like %?2% or c.email like %?3% or c.number like ?4%")
	public List<Customer> searchCustomers(String searchById, String searchByName, String searchByEmail,
			String searchByNumber);
}
