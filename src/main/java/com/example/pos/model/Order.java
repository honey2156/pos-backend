package com.example.pos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.pos.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author mandeepsingh
 *
 */
@Entity
@Table(name = TableConstants.ORDER)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean status;

	// @Temporal(TemporalType.DATE)
	// private Date orderDate;
	private String orderDate;

	private String orderTime;

	// private PaymentMode paymentMode;
	private String paymentMode;

	private double totalAmount;

//	@JsonBackReference("customerOrders")
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	@JsonBackReference("employeeOrders")
	@ManyToOne
	private Employee employee;

	@JsonManagedReference("orderDetails")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
	private List<OrderDetail> orderDetails;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	// public PaymentMode getPaymentMode() {
	// return paymentMode;
	// }
	//
	// public void setPaymentMode(PaymentMode paymentMode) {
	// this.paymentMode = paymentMode;
	// }

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
