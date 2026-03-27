package com.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * This the main Spring boot application configuration class
 * 
 * @author Shekar
 */
@SpringBootApplication(scanBasePackages = "com.io.*")
public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

  
		
		
  }
}