package com.example.pos.service;

import com.example.pos.model.CashDrawer;

public interface DrawerService {

	public CashDrawer getDrawer(int employeeId);

	public void setOpeningDrawerBalance(CashDrawer drawer, int employeeId);

	public void updateClosingDrawerBalance(CashDrawer drawer, int employeeId);
}
