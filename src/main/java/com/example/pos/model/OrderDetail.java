package com.example.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.pos.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = TableConstants.ORDER_DETAILS)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private int quantity;

	private int price;

	// private double subTotal;

	@JsonBackReference("orderDetails")
	@ManyToOne
	private Order order;

	@JsonBackReference("productOrderDetails")
	@ManyToOne
	private Product product;

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// public double getSubTotal() {
	// return subTotal;
	// }
	//
	// public void setSubTotal(double subTotal) {
	// this.subTotal = subTotal;
	// }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
