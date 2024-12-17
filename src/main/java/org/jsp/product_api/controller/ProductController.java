package org.jsp.product_api.controller;

import java.util.List;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/products")
	public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@PostMapping("/products/many")
	public ResponseEntity<Object> saveProducts(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}

	// Fetch All Products
	@GetMapping("/products")
	public ResponseEntity<Object> fetchAllProducts() {
		return service.fetchAllProducts();
	}

	// Fetch Product By Id
	@GetMapping("/products/{id}")
	public ResponseEntity<Object> fetchById(@PathVariable int id) {
		return service.fetchById(id);
	}

	// Fetch Product By Name
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Object> fetchByName(@PathVariable String name) {
		return service.fetchByName(name);
	}

	// Fetch Product By Stock Between
	@GetMapping("/products/stock/{min}/{max}")
	public ResponseEntity<Object> fetchByStockBetween(@PathVariable int min, @PathVariable int max) {
		return service.fetchByStockBetween(min, max);
	}

	// Fetch Product By Price Greater Than
	@GetMapping("/products/price/greater/{price}")
	public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price) {
		return service.fetchByPriceGreater(price);
	}

	// Delete Product By Id
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	// Update Product - PUt
	@PutMapping("/products")
	public ResponseEntity<Object> updateRecord(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	// Update Product - PATCH
	@PatchMapping("/products/{id}")
	public ResponseEntity<Object> updateRecord(@PathVariable int id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}

}
