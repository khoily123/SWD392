package com.example.swd392.service;

import com.example.swd392.dto.ProductDTO;
import com.example.swd392.dto.ProductUpdateDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(Integer id);
    public ProductDTO createProduct(ProductUpdateDTO newProduct);
    public ProductDTO updateProduct(Integer id, ProductUpdateDTO updatedProduct);
    public void deleteProduct(Integer id);
}
