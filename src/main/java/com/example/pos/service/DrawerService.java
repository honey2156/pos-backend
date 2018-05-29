package com.example.pos.service;

import java.util.List;

import com.example.pos.model.CashDrawer;

public interface DrawerService {

	public CashDrawer getDrawerById(int id);
	
	public CashDrawer getDrawer(int employeeId);
	
	public List<CashDrawer> getEmployeeDrawers(int employeeId);

	public void setOpeningDrawerBalance(CashDrawer drawer, int employeeId);

	public void updateClosingDrawerBalance(CashDrawer drawer, int employeeId);
}
