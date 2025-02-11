package com.example.projectswd.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    private String name;
    private BigDecimal price;
    private Integer category_id;
    private Integer brand_id;
    private Integer stock_quantity;

    @Column(length = 1000)
    private String description;
}
