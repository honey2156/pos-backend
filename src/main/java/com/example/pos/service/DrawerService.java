package com.example.pos.service;

import java.util.List;

import com.example.pos.model.CashDrawer;

/**
 * @author mandeepsingh
 *
 */
public interface DrawerService {

	/**
	 * Get cashdrawer by drawer id
	 * 
	 * @param id
	 * @return
	 */
	public CashDrawer getDrawerById(int id);

	/**
	 * Get drawer of employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public CashDrawer getDrawer(int employeeId);

	/**
	 * Get all drawers of employee
	 * 
	 * @param employeeId
	 * @return
	 */
	public List<CashDrawer> getEmployeeDrawers(int employeeId);

	/**
	 * Set opening balance of drawer
	 * 
	 * @param drawer
	 * @param employeeId
	 */
	public void setOpeningDrawerBalance(CashDrawer drawer, int employeeId);

	/**
	 * set closing balance of drawer
	 * 
	 * @param drawer
	 * @param employeeId
	 */
	public void updateClosingDrawerBalance(CashDrawer drawer, int employeeId);
}
