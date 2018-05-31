package com.example.pos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.pos.constants.TableConstants;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author mandeepsingh
 *
 */
@Entity
@Table(name = TableConstants.CASH_DRAWER, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "employee_id", "date" }) })
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CashDrawer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Column(unique = true, nullable = false)
	// @Temporal(TemporalType.DATE)
	// private Date date;
	private String date;

	@Column(nullable = false)
	private double startingBalance;

	@Column(nullable = false)
	private double endingBalance;

	@JsonBackReference("employeeDrawers")
	@ManyToOne
	private Employee employee;

	public CashDrawer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getStartingBalance() {
		return startingBalance;
	}

	public void setStartingBalance(double startingBalance) {
		this.startingBalance = startingBalance;
	}

	public double getEndingBalance() {
		return endingBalance;
	}

	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
