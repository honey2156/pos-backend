package com.example.pos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.example.pos.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = TableConstants.EMPLOYEE)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@Column
	private String phoneNumber;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	@JsonManagedReference
	@Fetch(FetchMode.SUBSELECT)
	private List<CashDrawer> cashDrawers;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	@JsonManagedReference
	private List<Order> orders;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String username, String password, String email, String phoneNumber) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.orders = new ArrayList<>();
		this.cashDrawers = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<CashDrawer> getCashDrawers() {
		return cashDrawers;
	}

	public void setCashDrawers(List<CashDrawer> cashDrawers) {
		this.cashDrawers = cashDrawers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
