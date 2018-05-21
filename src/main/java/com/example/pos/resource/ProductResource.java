package com.example.pos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.model.Product;
import com.example.pos.service.ProductService;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/seed")
	public void seedProducts() {
		List<Product> seededProducts = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			seededProducts.add(new Product("Item" + i, "Description" + i, i, 10));
		}
		productService.seedProducts(seededProducts);
	}
}
