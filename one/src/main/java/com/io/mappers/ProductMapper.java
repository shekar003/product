package com.io.mappers;

import org.mapstruct.Mapper;

import com.io.entity.Product;
import com.io.entity.ProductDTO;


@Mapper(componentModel = "spring")
public interface ProductMapper {

	
	ProductDTO productToProductDTO(Product product);
	
	Product productDTOToProduct(ProductDTO productDTO);
	
	
	
}
