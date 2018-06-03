package com.example.pos.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.DrawerDao;
import com.example.pos.dao.EmployeeDao;
import com.example.pos.model.CashDrawer;
import com.example.pos.model.Employee;
import com.example.pos.service.DrawerService;

/**
 * @author mandeepsingh
 *
 */
@Service
public class DrawerServiceImpl implements DrawerService {

	@Autowired
	private DrawerDao drawerDao;
	@Autowired
	private EmployeeDao employeeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.DrawerService#getDrawerById(int)
	 */
	@Override
	public CashDrawer getDrawerById(int id) {
		return drawerDao.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.DrawerService#getDrawer(int)
	 */
	@Override
	public CashDrawer getDrawer(int employeeId) {
		Employee employee = employeeDao.findById(employeeId);
		return drawerDao.getDrawerByDate(employee, this.getCurrentDate());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.DrawerService#getEmployeeDrawers(int)
	 */
	@Override
	public List<CashDrawer> getEmployeeDrawers(int employeeId) {
		Employee employee = employeeDao.findById(employeeId);
		return drawerDao.getEmployeeCashDrawers(employee);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.DrawerService#setOpeningDrawerBalance(com.example.pos
	 * .model.CashDrawer, int)
	 */
	@Override
	public void setOpeningDrawerBalance(CashDrawer drawer, int employeeId) {
		// Find employee by employee id
		Employee employee = employeeDao.findById(employeeId);

		// Initialize cash drawer
		if (drawerDao.getDrawerByDate(employee, this.getCurrentDate()) == null) {
			drawer.setEmployee(employee);
			drawer.setDate(getCurrentDate());
			drawer.setStartingBalance(drawer.getStartingBalance());
			drawer.setEndingBalance(drawer.getStartingBalance());
			drawerDao.save(drawer);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.DrawerService#updateClosingDrawerBalance(com.example.
	 * pos.model.CashDrawer, int)
	 */
	@Override
	public void updateClosingDrawerBalance(CashDrawer drawer, int employeeId) {
		// Find employee by employee id
		Employee employee = employeeDao.findById(employeeId);

		// Find current cash drawer of employee using employee and current date and
		// update ending balance
		CashDrawer cashDrawer = drawerDao.getDrawerByDate(employee, getCurrentDate());
		if (cashDrawer != null) {
			cashDrawer.setEndingBalance(cashDrawer.getEndingBalance() + drawer.getEndingBalance());
			drawerDao.save(cashDrawer);
		}
	}

	/**
	 * Returns current date from Date format to string format
	 * 
	 * @return
	 */
	private String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

}
