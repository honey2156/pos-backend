package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.CashDrawer;
import com.example.pos.model.Employee;

/**
 * @author mandeepsingh
 *
 */
@Repository
public interface DrawerDao extends CrudRepository<CashDrawer, Integer> {

	/**
	 * Find CashDrawer by drawer by drawer id
	 * 
	 * @param id
	 * @return
	 */
	public CashDrawer findById(int id);

	/**
	 * Find CashDrawer of employee on a given date
	 * 
	 * @param employee
	 * @param date
	 * @return
	 */
	@Query("select cd from CashDrawer cd where cd.employee = ?1 and cd.date = ?2")
	public CashDrawer getDrawerByDate(Employee employee, String date);

	/**
	 * Find all CashDrawers of employee
	 * 
	 * @param employee
	 * @return
	 */
	@Query("select cd from CashDrawer cd where cd.employee = ?1")
	public List<CashDrawer> getEmployeeCashDrawers(Employee employee);
}
