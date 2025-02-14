package com.example.swd392.repository;

import com.example.swd392.dto.ProductDTO;
import com.example.swd392.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT new com.example.swd392.dto.ProductDTO(p.productId, p.name, p.price, c.categoryName, b.brandName, p.stockQuantity, p.description) " +
            "FROM Product p " +
            "JOIN p.category c " +
            "JOIN p.brand b " +
            "WHERE p.productId = :id")
    ProductDTO findByIdWithCategoryAndBrand(@Param("id") Integer id);

    List<Product> findAllByName(String name);
}

