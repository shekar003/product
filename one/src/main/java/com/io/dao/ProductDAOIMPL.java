package com.io.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.service.ProductService;

import jakarta.transaction.Transactional;



/**
 * This is DAO class where we perform crud operations 
 * contains all the API methods
 * 
 * @author Shekar
 */

@Service
public class ProductDAOIMPL implements ProductDAO{

	@Override
	public List getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Autowired public ProductService productService;
	 * 
	 * @Transactional public List getAllProducts() {
	 * 
	 * List list = productService.getAllProdcts();
	 * 
	 * return list;
	 * 
	 * }
	 */

}
