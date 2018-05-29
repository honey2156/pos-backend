package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Order;

public interface OrderService {

	public List<Order> getAllOrders();

	public List<Order> getCustomerOrders(int customerId);
	
	public List<Order> getEmployeeOrders(int employeeId);

	public Order getOrder(int orderId);

	public void confirmOrder(int orderId);

	public Order order(Order order, int employeeId, int customerId);
	
	public void updateCashDrawer(Order order);
	
	public List<Order> getOrdersByCashDrawer(int cashDrawerId);
}
