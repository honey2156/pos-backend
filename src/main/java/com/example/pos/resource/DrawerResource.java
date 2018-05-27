package com.example.pos.resource;

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

@RestController
@RequestMapping(value = "employees/{employeeId}/drawers")
@CrossOrigin(origins = { "http://localhost:4200" })
public class DrawerResource {

	@Autowired
	private DrawerService drawerService;

	@GetMapping
	public CashDrawer getDrawer(@PathVariable("employeeId") int employeeId) {
		return drawerService.getDrawer(employeeId);
	}

	@PostMapping
	public void setOpeningDrawerBalance(@RequestBody CashDrawer cashDrawer, @PathVariable int employeeId) {
		drawerService.setOpeningDrawerBalance(cashDrawer, employeeId);
	}

	@PutMapping
	public void updateClosingDrawerBalance(@RequestBody CashDrawer cashDrawer, @PathVariable int employeeId) {
		drawerService.updateClosingDrawerBalance(cashDrawer, employeeId);
	}
}
