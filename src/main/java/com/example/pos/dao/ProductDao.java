package com.example.pos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

	public Product findById(int id);

	public List<Product> findByName(String name);

	public List<Product> findByDescription(String description);

	@Query("select p from Product p where CONCAT(p.id, '') like ?1% or p.name like %?2% or p.description like %?3% ")
	public List<Product> searchProducts(String searchById, String searchByName, String description);
}
