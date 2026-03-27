package com.io.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.io.dao.ProductRepository;
import com.io.entity.Product;
import com.io.entity.ProductDTO;
import com.io.entity.ProductMapper;
import com.io.validations.NoProductFoundException;

/**
 * This Service class where this acts as bridge between Controller and
 * Repository
 * 
 * @author Shekar
 */

@Service
public class ProductServiceIMPL implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceIMPL.class);

	 
	 //private ProductMapper productMapper;

	 @Autowired
	 private ProductRepository productRepository;

	
	/**
	 * createProduct method create a new product in Database
	 * 
	 * @param Product
	 */
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * getByProductbyId method is used to fetch product details with ID
	 * 
	 * @param Long product id
	 */
	@Override
	public Product getProductbyId(Long id) {
		log.info("ProductServiceIMPL : getProductbyId execution starts");

		return productRepository.findById(id)
				.orElseThrow(() -> new NoProductFoundException("No Product Found with Id = ", id));
	}

	/**
	 * getAllProdcts method fetches all the product available in Database
	 * 
	 * @param not applicable
	 */
	@Override
	public List<Product> getAllProdcts() {
		log.info("ProductServiceIMPL : getAllProdcts execution starts");

		return (List<Product>) productRepository.findAll();

	}

	/**
	 * getAllProdcts method fetches all the products with paging
	 * 
	 * @param not applicable
	 */
	@Override
	public Page getAllProdcts(org.springframework.data.domain.Pageable pageable) {
		log.debug("FrOM IMPL SERVIECE");
		return productRepository.findAll(pageable);
	}

	/**
	 * updateProduct method is used to update product details
	 * 
	 * @param Product
	 */
	@Override
	public Product updateProduct(Product product) {
		log.info("ProductServiceIMPL : updateProduct execution starts");

		Product existingProduct = productRepository.findById(product.getId()).get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		Product updatedProduct = productRepository.save(existingProduct);
		log.info("ProductServiceIMPL : getAllProdcts execution ends");

		return updatedProduct;
	}

	/**
	 * deleteProduct method is to delete a product which is soft delete
	 * 
	 * @param Long product id
	 */

	@Override
	@Transactional
	public void deleteProduct(Long id) {
		log.info("ProductServiceIMPL : deleteProduct execution starts");

		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		product.setDeleted(true);
		log.info("ProductServiceIMPL : deleteProduct execution ends");

		productRepository.save(product);
	}

	/**
	 * deleteProductHard method is to delete a product which is hard delete
	 * 
	 * @param Long product id
	 */
	@Override
	public void deleteProductHard(Long id) {

		productRepository.delete(getProductbyId(id));

	}

	@Override
	public Product getProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public Product getProductsByPrice(Double price) {
		return productRepository.findByPrice(price);
	}

	@Override
	public ProductDTO getProductByName(String name) {

		log.info("NAME : " + name);

		Product product = productRepository.findByName(name);

		// ProductDTO productDTO = productMapper.productToProductDTO(product);

		return null;
	}

	/**
	 * Method partialUpdateProduct is to update a product partially
	 * 
	 * @param Long product id
	 */
	@Override
	public Product partialUpdateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		Product updatedProduct = productRepository.save(existingProduct);

		return updatedProduct;
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);

	}

	public Page findProductWithsameName(String name, Pageable pageable) {

		Page page = productRepository.findProductWithsameName(name, pageable);

		return page;
	}

}