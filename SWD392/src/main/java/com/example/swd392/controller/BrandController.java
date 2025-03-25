package com.example.swd392.controller;

import com.example.swd392.dto.BrandDTO;
import com.example.swd392.dto.CategoryDTO;
import com.example.swd392.service.BrandService;
import com.example.swd392.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins = "*") // Cho phép tất cả các nguồn truy cập

public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllCategories() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }
}
