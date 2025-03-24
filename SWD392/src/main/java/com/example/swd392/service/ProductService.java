package com.example.swd392.service;

import com.example.swd392.dto.ProductDTO;
import com.example.swd392.dto.ProductUpdateDTO;

import java.util.List;

public interface ProductService {
     List<ProductDTO> getAllProducts();
     ProductDTO getProductById(Integer id);
     ProductDTO createProduct(ProductUpdateDTO newProduct);
     ProductDTO updateProduct(Integer id, ProductUpdateDTO updatedProduct);
     void deleteProduct(Integer id);
}
