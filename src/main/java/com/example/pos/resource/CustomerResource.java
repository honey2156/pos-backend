package com.example.pos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.model.Customer;
import com.example.pos.service.CustomerService;

@RestController
@RequestMapping(value = "customers")
public class CustomerResource {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(value="/seed")
	public void seedCustomers() {
		List<Customer> seededCustomers = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			seededCustomers.add(new Customer("Customer" + i, "customer" + i + "@email.com", "123456789"+i));
		}
		customerService.seedCustomers(seededCustomers);
	}

}
