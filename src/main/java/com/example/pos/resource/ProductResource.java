package com.example.pos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.constants.ResourceConstants;
import com.example.pos.model.Product;
import com.example.pos.service.ProductService;

/**
 * Controller that handles product requests
 * 
 * @author mandeepsingh
 *
 */
@RestController
@RequestMapping(value = ResourceConstants.PRODUCT_BASE)
@CrossOrigin(origins = { "http://localhost:4200" })
public class ProductResource {

	@Autowired
	private ProductService productService;

	/**
	 * Get all products
	 * 
	 * @return
	 */
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	/**
	 * Seed for products
	 */
	@GetMapping(value = ResourceConstants.PRODUCT_SEED)
	public void seedProducts() {
		List<Product> seededProducts = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			seededProducts.add(new Product("Item" + i, "Best product ever " + i, i, 10));
		}
		productService.seedProducts(seededProducts);
	}

	/**
	 * Search products by search pattern
	 * 
	 * @param searchPattern
	 * @return
	 */
	@GetMapping(value = ResourceConstants.PRODUCT_SEARCH)
	public List<Product> searchProducts(@PathVariable("searchPattern") String searchPattern) {
		return productService.searchProducts(searchPattern);
	}
}
