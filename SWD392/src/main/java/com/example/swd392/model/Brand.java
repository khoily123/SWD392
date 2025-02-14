package com.example.swd392.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "name", nullable = false, length = 255)
    private String brandName;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;
}
