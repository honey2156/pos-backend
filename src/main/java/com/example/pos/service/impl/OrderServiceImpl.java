package com.example.pos.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.constants.enums.PaymentMode;
import com.example.pos.dao.CustomerDao;
import com.example.pos.dao.EmployeeDao;
import com.example.pos.dao.OrderDao;
import com.example.pos.dao.OrderDetailDao;
import com.example.pos.dao.ProductDao;
import com.example.pos.model.CashDrawer;
import com.example.pos.model.Customer;
import com.example.pos.model.Employee;
import com.example.pos.model.Order;
import com.example.pos.model.OrderDetail;
import com.example.pos.model.Product;
import com.example.pos.service.DrawerService;
import com.example.pos.service.OrderService;

/**
 * @author mandeepsingh
 *
 */
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

	@Autowired
	private DrawerService drawerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#getAllOrders()
	 */
	@Override
	public List<Order> getAllOrders() {
		return (List<Order>) orderDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#getCustomerOrders(int)
	 */
	@Override
	public List<Order> getCustomerOrders(int customerId) {
		return customerDao.findById(customerId).getOrders();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#getEmployeeOrders(int)
	 */
	@Override
	public List<Order> getEmployeeOrders(int employeeId) {
		Employee employee = employeeDao.findById(employeeId);
		return orderDao.findAllByEmployee(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#getOrder(int)
	 */
	@Override
	public Order getOrder(int orderId) {
		return orderDao.findById(orderId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#confirmOrder(int)
	 */
	@Override
	public void confirmOrder(int orderId) {
		// Find Order by order id
		Order order = orderDao.findById(orderId);
		// update payment status to true
		order.setStatus(true);
		// update stock of all the products in the order after confirmation of order
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for (OrderDetail orderDetail : orderDetails) {
			int minusFactor = orderDetail.getQuantity();
			Product product = orderDetail.getProduct();
			product.setStock(product.getStock() - minusFactor);
			productDao.save(product);
		}
		orderDao.save(order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#order(com.example.pos.model.Order,
	 * int, int)
	 */
	@Override
	public Order order(Order order, int employeeId, int customerId) {
		// Find employee by employee id
		Employee employee = employeeDao.findById(employeeId);
		// Find customer by customer id
		Customer customer = customerDao.findById(customerId);
		// Initialize order
		order.setEmployee(employee);
		order.setCustomer(customer);
		order.setOrderDate(this.currentDate());
		order.setOrderTime(this.currentTime());
		order = orderDao.save(order);
		orderDetailDao.saveAll(order.getOrderDetails());
		// If order is placed then confirm order
		if (order.isStatus()) {
			this.confirmOrder(order.getId());
			// If payment mode is by Cash then update cash drawer
			if (PaymentMode.CASH.getName().equals(order.getPaymentMode())) {
				this.updateCashDrawer(order);
			}
		}
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.OrderService#updateCashDrawer(com.example.pos.model.
	 * Order)
	 */
	@Override
	public void updateCashDrawer(Order order) {
		// Create cash drawer object for passing updated ending balance
		CashDrawer drawer = new CashDrawer();
		drawer.setEndingBalance(order.getTotalAmount());
		drawerService.updateClosingDrawerBalance(drawer, order.getEmployee().getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.OrderService#getOrdersByCashDrawer(int)
	 */
	@Override
	public List<Order> getOrdersByCashDrawer(int cashDrawerId) {
		CashDrawer cashDrawer = drawerService.getDrawerById(cashDrawerId);
		return orderDao.getOrdersByCashDrawer(cashDrawer.getEmployee(), cashDrawer.getDate());
	}

	/**
	 * Returns current date from Date format to string format
	 * 
	 * @return
	 */
	private String currentDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(date);
	}

	/**
	 * Returns current time from Date format to string format
	 * 
	 * @return
	 */
	private String currentTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
		return dateFormat.format(date);
	}
}
