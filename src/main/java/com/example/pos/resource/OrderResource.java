package com.example.pos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.model.Order;
import com.example.pos.service.OrderService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "employees/{employeeId}/customers/{customerId}/orders")
	public Order placeOrder(@PathVariable("employeeId") int employeeId, @PathVariable("customerId") int customerId,
			@RequestBody Order order) {
		return orderService.order(order, employeeId, customerId);
	}

	@GetMapping(value = "employees/{employeeId}/customers/{customerId}/orders/{orderId}")
	public void confirmOrder(@PathVariable("employeeId") int employeeId, @PathVariable("customerId") int customerId,
			@PathVariable int orderId) {
		orderService.confirmOrder(orderId);
	}
	
	@GetMapping(value="employees/{employeeId}/orders")
	public List<Order> getEmployeeOrders(@PathVariable int employeeId){
		return orderService.getEmployeeOrders(employeeId);
	}
	
	@GetMapping(value="cashdrawers/{cashDrawerId}/orders")
	public List<Order> getOrdersByCashDrawer(@PathVariable int cashDrawerId){
		return orderService.getOrdersByCashDrawer(cashDrawerId);
	}
}
