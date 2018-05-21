package com.example.pos.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pos.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

	public Product findById(int id);

	public List<Product> findByName(String name);

	public List<Product> findByDescription(String description);
}
