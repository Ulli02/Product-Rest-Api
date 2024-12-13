package org.jsp.product_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsp.product_api.dto.Product;
import org.jsp.product_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;

	public ResponseEntity<Object> saveProduct(Product product) {
		repository.save(product);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", product);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> saveProducts(List<Product> product) {
		repository.saveAll(product);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", product);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

}
