package com.example.swd392.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateDTO {
    private String name;
    private BigDecimal price;
    private String categoryName;
    private String brandName;
    private Integer stockQuantity;
    private String description;
    private Integer categoryId;
    private Integer brandId;
}

