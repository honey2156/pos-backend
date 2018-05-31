package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Order;

/**
 * @author mandeepsingh
 *
 */
public interface OrderService {

	/**
	 * Get all orders
	 * 
	 * @return
	 */
	public List<Order> getAllOrders();

	/**
	 * Get customer orders
	 * 
	 * @param customerId
	 * @return
	 */
	public List<Order> getCustomerOrders(int customerId);

	/**
	 * Get employee orders
	 * 
	 * @param employeeId
	 * @return
	 */
	public List<Order> getEmployeeOrders(int employeeId);

	/**
	 * Get order by order by id
	 * 
	 * @param orderId
	 * @return
	 */
	public Order getOrder(int orderId);

	/**
	 * Confirm placed status of order
	 * 
	 * @param orderId
	 */
	public void confirmOrder(int orderId);

	/**
	 * Create order of customer by employee
	 * 
	 * @param order
	 * @param employeeId
	 * @param customerId
	 * @return
	 */
	public Order order(Order order, int employeeId, int customerId);

	/**
	 * Update cashdrawer of employee
	 * 
	 * @param order
	 */
	public void updateCashDrawer(Order order);

	/**
	 * Get orders served by cashdrawer
	 * 
	 * @param cashDrawerId
	 * @return
	 */
	public List<Order> getOrdersByCashDrawer(int cashDrawerId);
}
