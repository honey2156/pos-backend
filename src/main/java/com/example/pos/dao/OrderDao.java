package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.Employee;
import com.example.pos.model.Order;

/**
 * @author mandeepsingh
 *
 */
public interface OrderDao extends CrudRepository<Order, Integer> {

	/**
	 * Find Order by order id
	 * 
	 * @param id
	 * @return
	 */
	public Order findById(int id);

	/**
	 * Find all orders of employee
	 * 
	 * @param employee
	 * @return
	 */
	public List<Order> findAllByEmployee(Employee employee);

	/**
	 * Find all orders served by a cash drawer on a given date
	 * 
	 * @param employee
	 * @param date
	 * @return
	 */
	@Query("select o from Order o where o.employee = ?1 and o.orderDate = ?2")
	public List<Order> getOrdersByCashDrawer(Employee employee, String date);
}
