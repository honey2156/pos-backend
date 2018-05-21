package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductByCode(int productCode);
	
	public List<Product> getProductsByName(String name);
	
	public List<Product> getProductsByDescription(String description);
	
	public void updateProduct(Product product);
	
	public void seedProducts(List<Product> seededProducts);
}
