package com.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "price must be greater than 0")
    @NotNull(message = "price cannot be null")
    private Double price;

    @Min(value = 0, message = "quantity must be >= 0")
    private Integer quantity;

    private String category;

    private boolean deleted = false;
}