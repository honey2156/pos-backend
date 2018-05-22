package com.example.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.ProductDao;
import com.example.pos.model.Product;
import com.example.pos.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product getProductByCode(int productCode) {
		return productDao.findById(productCode);
	}

	@Override
	public List<Product> getProductsByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public List<Product> getProductsByDescription(String description) {
		return productDao.findByDescription(description);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> searchProducts(String searchPattern) {
		return productDao.searchProducts(searchPattern, searchPattern, searchPattern);
	}

	@Override
	public void seedProducts(List<Product> seededProducts) {
		productDao.saveAll(seededProducts);
	}

}
