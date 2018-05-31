package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.Product;

/**
 * @author mandeepsingh
 *
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

	/**
	 * Find product by product id
	 * 
	 * @param id
	 * @return
	 */
	public Product findById(int id);

	/**
	 * Find Products by name
	 * 
	 * @param name
	 * @return
	 */
	public List<Product> findByName(String name);

	/**
	 * Find products by description
	 * 
	 * @param description
	 * @return
	 */
	public List<Product> findByDescription(String description);

	/**
	 * Search products by search pattern
	 * 
	 * @param searchById
	 * @param searchByName
	 * @param description
	 * @return
	 */
	@Query("select p from Product p where CONCAT(p.id, '') like ?1% or p.name like %?2% or p.description like %?3% ")
	public List<Product> searchProducts(String searchById, String searchByName, String description);
}
