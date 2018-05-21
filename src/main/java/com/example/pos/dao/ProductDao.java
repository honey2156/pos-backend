package com.example.pos.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.pos.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {

	public Product findById(int id);

	public List<Product> findByName(String name);

	public List<Product> findByDescription(String description);
}
