package com.io.entity;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface ProductMapper {

	
	ProductDTO productToProductDTO(Product product);
	
	Product productDTOToProduct(ProductDTO productDTO);
	
	
	
}
