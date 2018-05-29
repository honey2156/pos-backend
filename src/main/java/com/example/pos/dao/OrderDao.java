package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.Employee;
import com.example.pos.model.Order;

public interface OrderDao extends CrudRepository<Order, Integer> {

	public Order findById(int id);

	public List<Order> findAllByEmployee(Employee employee);
	
	@Query("select o from Order o where o.employee = ?1 and o.orderDate = ?2")
	public List<Order> getOrdersByCashDrawer(Employee employee, String date);
}
