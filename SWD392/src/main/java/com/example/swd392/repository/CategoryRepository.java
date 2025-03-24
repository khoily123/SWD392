package com.example.swd392.repository;
import com.example.swd392.dto.CategoryDTO;
import com.example.swd392.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCategoryName(String categoryName);

    @Query("SELECT new com.example.swd392.dto.CategoryDTO(c.categoryId,c.categoryName, c.description) " +
            "FROM Category c " +
            "WHERE c.categoryId = :id")
    CategoryDTO findCategoryById(@Param("id") Integer id);


    List<Category> findAllByCategoryName(String categoryName);

}
