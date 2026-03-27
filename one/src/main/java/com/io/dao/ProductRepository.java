package com.io.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.io.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	Product findByName(String name);
	
	Page<Product> findAll(Pageable pageable);
	
    Product findByPrice(Double price);

	Product findByCategory(String category);
	
	@Query(value="select * from product where name = :productName and deleted=false", nativeQuery=true)
	Page<Product> findProductWithsameName(@Param("productName")String productName, Pageable pageable);
	
	
}
