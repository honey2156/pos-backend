package com.example.pos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos.dao.ProductDao;
import com.example.pos.model.Product;
import com.example.pos.service.ProductService;

/**
 * @author mandeepsingh
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.ProductService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.ProductService#getProductByCode(int)
	 */
	@Override
	public Product getProductByCode(int productCode) {
		return productDao.findById(productCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.ProductService#getProductsByName(java.lang.String)
	 */
	@Override
	public List<Product> getProductsByName(String name) {
		return productDao.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.ProductService#getProductsByDescription(java.lang.
	 * String)
	 */
	@Override
	public List<Product> getProductsByDescription(String description) {
		return productDao.findByDescription(description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.pos.service.ProductService#updateProduct(com.example.pos.model.
	 * Product)
	 */
	@Override
	public void updateProduct(Product product) {
		productDao.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.ProductService#searchProducts(java.lang.String)
	 */
	@Override
	public List<Product> searchProducts(String searchPattern) {
		return productDao.searchProducts(searchPattern, searchPattern, searchPattern);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.pos.service.ProductService#seedProducts(java.util.List)
	 */
	@Override
	public void seedProducts(List<Product> seededProducts) {
		productDao.saveAll(seededProducts);
	}

}
