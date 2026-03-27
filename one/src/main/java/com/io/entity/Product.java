package com.io.entity;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents products which contains multiple properties
 * 
 * @author Shekar
 */

/*
 * We can avoid setter and getter methods by using below lombok framework
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Setter
 * 
 * @Getter
 * 
 * @ToString
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity(name = "product")
public class Product {

	// Properties which point outs the columns in the Database table

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@Min(value= 1, message = "price must be greate than 0")
	@NotNull(message = "price cannot be null")
	private Double price;

	@Min(value = 0, message = "value must in between 1 to 100")
	private Integer quantity;

	private String category;

	private boolean deleted = Boolean.FALSE;

	// constructors with zero and parameterized values

	public Product() {

	}

	public Product(Long i, String name, Double price, Integer quanity, String category) {
	}

	public Product(Long id, String name) {

	}

	public Product(Long i, String name, Double price) {

	}

	public Product(Long i, String name, String category) {

	}

	// setter and getter method to perform operations

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


}
