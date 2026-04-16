package com.io.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.io.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	@Query(value = "select * from product where lower(name) like %:name% and deleted=false ", nativeQuery=true)
	List<Product> findByNameIgnoreCaseAndDeletedFalse(@Param("name") String name);
	
	List<Product> findByNameAndDeletedFalse(String name);
	
	@Override
	Page<Product> findAll(Pageable pageable);
	
    Product findByPrice(Double price);

	Product findByCategory(String category);
	
	@Query(value="select * from product where name = :productName and deleted=false", nativeQuery=true)
	Page<Product> findProductWithsameName(@Param("productName")String productName, Pageable pageable);
	
	
	
	@Query(value="select * from product where quantity=''", nativeQuery=true)
	public List getAllProductsAndQuantityisNull();
	
}









