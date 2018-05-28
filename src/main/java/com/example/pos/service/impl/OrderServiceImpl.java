package com.example.pos.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.CustomerDao;
import com.example.pos.dao.EmployeeDao;
import com.example.pos.dao.OrderDao;
import com.example.pos.dao.OrderDetailDao;
import com.example.pos.dao.ProductDao;
import com.example.pos.model.Customer;
import com.example.pos.model.Employee;
import com.example.pos.model.Order;
import com.example.pos.model.OrderDetail;
import com.example.pos.model.Product;
import com.example.pos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public List<Order> getAllOrders() {
		return (List<Order>) orderDao.findAll();
	}

	@Override
	public List<Order> getCustomerOrders(int customerId) {
		return customerDao.findById(customerId).getOrders();
	}

	@Override
	public Order getOrder(int orderId) {
		return orderDao.findById(orderId);
	}

	@Override
	public void confirmOrder(int orderId) {
		Order order = orderDao.findById(orderId);
		order.setStatus(true);
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for (OrderDetail orderDetail : orderDetails) {
			int minusFactor = orderDetail.getQuantity();
			Product product = orderDetail.getProduct();
			product.setStock(product.getStock() - minusFactor);
			productDao.save(product);
		}
		orderDao.save(order);
	}

	@Override
	public Order order(Order order, int employeeId, int customerId) {

		Employee employee = employeeDao.findById(employeeId);
		Customer customer = customerDao.findById(customerId);
		order.setEmployee(employee);
		order.setCustomer(customer);
		order.setOrderDate(this.currentDate());
		order.setOrderTime(this.currentTime());
		order = orderDao.save(order);
		orderDetailDao.saveAll(order.getOrderDetails());
		if(order.isStatus()) {
			this.confirmOrder(order.getId());
		}
		return order;
	}

	private String currentDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(date);
	}

	private String currentTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
		return dateFormat.format(date);
	}
}
