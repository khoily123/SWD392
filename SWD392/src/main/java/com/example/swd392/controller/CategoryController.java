package com.example.swd392.controller;

import com.example.swd392.dto.CategoryDTO;
import com.example.swd392.dto.CategoryUpdateDTO;
import com.example.swd392.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*") // Cho phép tất cả các nguồn truy cập

public class CategoryController {


        private final CategoryService categoryService;

        @Autowired
        public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @GetMapping
        public ResponseEntity<List<CategoryDTO>> getAllCategories() {
            return ResponseEntity.ok(categoryService.getAllCategories());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id) {
            CategoryDTO categoryDTO = categoryService.getCategoryById(id);
            return categoryDTO != null ? ResponseEntity.ok(categoryDTO) : ResponseEntity.notFound().build();
        }

        @PostMapping
        public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryUpdateDTO newCategory) {
            System.out.println(newCategory.toString());
            return ResponseEntity.ok(categoryService.createCategory(newCategory));
        }

        @PutMapping("/{id}")
        public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @RequestBody CategoryUpdateDTO updatedCategory) {
            CategoryDTO categoryDTO = categoryService.updateCategory(id, updatedCategory);
            return categoryDTO != null ? ResponseEntity.ok(categoryDTO) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
}
