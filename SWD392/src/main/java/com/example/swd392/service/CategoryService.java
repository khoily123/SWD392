package com.example.swd392.service;
import com.example.swd392.dto.CategoryDTO;
import com.example.swd392.dto.CategoryUpdateDTO;

import java.util.List;

public interface CategoryService {
     List<CategoryDTO> getAllCategories();
     CategoryDTO getCategoryById(Integer id);
     CategoryDTO createCategory(CategoryUpdateDTO newProduct);
     CategoryDTO updateCategory(Integer id, CategoryUpdateDTO updatedProduct);
     void deleteCategory(Integer id);
}
