package com.example.pos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.model.CashDrawer;
import com.example.pos.service.DrawerService;

/**
 * @author mandeepsingh
 *
 */
@RestController
@RequestMapping(value = "employees/{employeeId}/drawers")
@CrossOrigin(origins = { "http://localhost:4200" })
public class DrawerResource {

	@Autowired
	private DrawerService drawerService;

	/**
	 * Get current cashdrawer of employee
	 * 
	 * @param employeeId
	 * @return
	 */
	@GetMapping
	public CashDrawer getDrawer(@PathVariable("employeeId") int employeeId) {
		return drawerService.getDrawer(employeeId);
	}

	/**
	 * Get all cashdrawers of employee
	 * 
	 * @param employeeId
	 * @return
	 */
	@GetMapping(value = "/all")
	public List<CashDrawer> getEmployeeDrawers(@PathVariable("employeeId") int employeeId) {
		return drawerService.getEmployeeDrawers(employeeId);
	}

	/**
	 * Set opening balance of current drawer
	 * 
	 * @param cashDrawer
	 * @param employeeId
	 */
	@PostMapping
	public void setOpeningDrawerBalance(@RequestBody CashDrawer cashDrawer, @PathVariable int employeeId) {
		drawerService.setOpeningDrawerBalance(cashDrawer, employeeId);
	}

	/**
	 * Update closing balance of current drawer
	 * 
	 * @param cashDrawer
	 * @param employeeId
	 */
	@PutMapping
	public void updateClosingDrawerBalance(@RequestBody CashDrawer cashDrawer, @PathVariable int employeeId) {
		drawerService.updateClosingDrawerBalance(cashDrawer, employeeId);
	}
}
