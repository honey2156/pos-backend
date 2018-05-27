package com.example.pos.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.DrawerDao;
import com.example.pos.dao.EmployeeDao;
import com.example.pos.model.CashDrawer;
import com.example.pos.model.Employee;
import com.example.pos.service.DrawerService;

@Service
public class DrawerServiceImpl implements DrawerService {

	@Autowired
	private DrawerDao drawerDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public CashDrawer getDrawer(int employeeId) {
		Employee employee = employeeDao.findById(employeeId);
		return drawerDao.getDrawerByDate(employee, this.getCurrentDate());
	}

	@Override
	public void setOpeningDrawerBalance(CashDrawer drawer, int employeeId) {
		Employee employee = employeeDao.findById(employeeId);
		if (drawerDao.getDrawerByDate(employee, this.getCurrentDate()) == null) {
			drawer.setEmployee(employee);
			drawer.setDate(getCurrentDate());
			drawer.setStartingBalance(drawer.getStartingBalance());
			drawer.setEndingBalance(drawer.getStartingBalance());
			drawerDao.save(drawer);
		}
	}

	@Override
	public void updateClosingDrawerBalance(CashDrawer drawer, int employeeId) {
		Employee employee = employeeDao.findById(employeeId);
		CashDrawer cashDrawer = drawerDao.getDrawerByDate(employee, getCurrentDate());
		if (cashDrawer != null) {
			cashDrawer.setEndingBalance(cashDrawer.getEndingBalance() + drawer.getEndingBalance());
			drawerDao.save(cashDrawer);
		}
	}

	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

}
