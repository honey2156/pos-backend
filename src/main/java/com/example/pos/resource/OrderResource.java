package com.example.pos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.constants.ResourceConstants;
import com.example.pos.model.Order;
import com.example.pos.service.OrderService;

/**
 * Controller that handles order requests
 * 
 * @author mandeepsingh
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
public class OrderResource {

	@Autowired
	private OrderService orderService;

	/**
	 * Place order of customer by employee
	 * 
	 * @param employeeId
	 * @param customerId
	 * @param order
	 * @return
	 */
	@PostMapping(value = ResourceConstants.PLACE_ORDER)
	public Order placeOrder(@PathVariable("employeeId") int employeeId, @PathVariable("customerId") int customerId,
			@RequestBody Order order) {
		return orderService.order(order, employeeId, customerId);
	}

	/**
	 * Confirm order by order id
	 * 
	 * @param employeeId
	 * @param customerId
	 * @param orderId
	 */
	@GetMapping(value = ResourceConstants.CONFIRM_ORDER)
	public void confirmOrder(@PathVariable("employeeId") int employeeId, @PathVariable("customerId") int customerId,
			@PathVariable int orderId) {
		orderService.confirmOrder(orderId);
	}

	/**
	 * Get orders of employee
	 * 
	 * @param employeeId
	 * @return
	 */
	@GetMapping(value = ResourceConstants.EMPLOYEE_ORDERS)
	public List<Order> getEmployeeOrders(@PathVariable int employeeId) {
		return orderService.getEmployeeOrders(employeeId);
	}

	/**
	 * Get all orders served by cashdrawer
	 * 
	 * @param cashDrawerId
	 * @return
	 */
	@GetMapping(value = ResourceConstants.CASHDRAWER_ORDERS)
	public List<Order> getOrdersByCashDrawer(@PathVariable int cashDrawerId) {
		return orderService.getOrdersByCashDrawer(cashDrawerId);
	}
}
