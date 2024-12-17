package org.jsp.product_api.repository;

import java.util.List;

import org.jsp.product_api.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> findByStockBetween(int min, int max);

	List<Product> findByPriceGreaterThanEqual(double price);

}
