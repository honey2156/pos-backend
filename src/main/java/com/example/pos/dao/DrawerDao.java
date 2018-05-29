package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.CashDrawer;
import com.example.pos.model.Employee;

@Repository
public interface DrawerDao extends CrudRepository<CashDrawer, Integer> {
	
	public CashDrawer findById(int id);

	@Query("select cd from CashDrawer cd where cd.employee = ?1 and cd.date = ?2")
	public CashDrawer getDrawerByDate(Employee employee, String date);
	
	@Query("select cd from CashDrawer cd where cd.employee = ?1")
	public List<CashDrawer> getEmployeeCashDrawers(Employee employee);
}
