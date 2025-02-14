package com.example.swd392.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer productId;
    private String name;
    private BigDecimal price;
    private String categoryName;
    private String brandName;
    private Integer stockQuantity;
    private String description;
}

