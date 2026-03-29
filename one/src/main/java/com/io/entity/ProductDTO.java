package com.io.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    
    @NotEmpty(message="Name cannot be empty")
    private String name;
    private Double price;
    private Integer quantity;
    private String category;

}