package com.example.pos.service;

import java.util.List;

import com.example.pos.model.Product;

public interface ProductService {

	/**
	 * Get all products
	 * 
	 * @return
	 */
	public List<Product> getAllProducts();

	/**
	 * Get products by product id
	 * 
	 * @param productCode
	 * @return
	 */
	public Product getProductByCode(int productCode);

	/**
	 * Get products by product name
	 * 
	 * @param name
	 * @return
	 */
	public List<Product> getProductsByName(String name);

	/**
	 * Get products by product description
	 * 
	 * @param description
	 * @return
	 */
	public List<Product> getProductsByDescription(String description);

	/**
	 * Update product stock
	 * 
	 * @param product
	 */
	public void updateProduct(Product product);

	/**
	 * Search products by search pattern
	 * 
	 * @param searchPattern
	 * @return
	 */
	public List<Product> searchProducts(String searchPattern);

	/**
	 * Seed products
	 * 
	 * @param seededProducts
	 */
	public void seedProducts(List<Product> seededProducts);
}
