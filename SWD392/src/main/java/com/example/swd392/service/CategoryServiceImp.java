package com.example.swd392.service;

import com.example.swd392.dto.CategoryDTO;
import com.example.swd392.dto.CategoryUpdateDTO;
import com.example.swd392.model.Category;
import com.example.swd392.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp  implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository1) {
        this.categoryRepository = categoryRepository1;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(p ->
                        new CategoryDTO(p.getCategoryId(), p.getCategoryName(), p.getDescription()))
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    public CategoryDTO createCategory(CategoryUpdateDTO newCategory) {
        List<Category> categoryList = categoryRepository.findAllByCategoryName(newCategory.getCategoryName());
        for (Category c : categoryList) {
            if(c.equals(newCategory)) {
                return (CategoryDTO) ResponseEntity.badRequest();
            }
        }

        Category category = new Category();
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());

        categoryRepository.save(category);
        return categoryRepository.findCategoryById(category.getCategoryId());
    }

    public CategoryDTO updateCategory(Integer id, CategoryUpdateDTO updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setDescription(updatedCategory.getDescription());
            categoryRepository.save(category);
            return categoryRepository.findCategoryById(id);
        }).orElse(null);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
