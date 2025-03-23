package com.example.swd392.service;

import com.example.swd392.dto.ProductDTO;
import com.example.swd392.dto.ProductUpdateDTO;
import com.example.swd392.model.Brand;
import com.example.swd392.model.Category;
import com.example.swd392.model.Product;
import com.example.swd392.repository.BrandRepository;
import com.example.swd392.repository.CategoryRepository;
import com.example.swd392.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(p ->
                        new ProductDTO(p.getProductId(), p.getName(), p.getPrice(),
                                p.getCategory().getCategoryName(), p.getBrand().getBrandName(),
                                p.getStockQuantity(), p.getDescription()))
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Integer id) {
        return productRepository.findByIdWithCategoryAndBrand(id);
    }

    public ProductDTO createProduct(ProductUpdateDTO newProduct) {
        List<Product> productList = productRepository.findAllByName(newProduct.getName());
        for (Product p : productList) {
            if(p.equals(newProduct)) {
                return (ProductDTO) ResponseEntity.badRequest();
            }
        }
        Category category = categoryRepository.findByCategoryName(newProduct.getCategoryName())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setCategoryName(newProduct.getCategoryName());
                    return categoryRepository.save(newCategory);
                });

        Brand brand = brandRepository.findByBrandName(newProduct.getBrandName())
                .orElseGet(() -> {
                    Brand newBrand = new Brand();
                    newBrand.setBrandName(newProduct.getBrandName());
                    return brandRepository.save(newBrand);
                });

        Product product = new Product();
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setCategory(category);
        product.setBrand(brand);
        product.setStockQuantity(newProduct.getStockQuantity());
        product.setDescription(newProduct.getDescription());

        productRepository.save(product);
        return productRepository.findByIdWithCategoryAndBrand(product.getProductId());
    }

    public ProductDTO updateProduct(Integer id, ProductUpdateDTO updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());

            Category category = categoryRepository.findByCategoryName(updatedProduct.getCategoryName())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            Brand brand = brandRepository.findByBrandName(updatedProduct.getBrandName())
                    .orElseThrow(() -> new RuntimeException("Brand not found"));

            product.setCategory(category);
            product.setBrand(brand);
            product.setStockQuantity(updatedProduct.getStockQuantity());
            product.setDescription(updatedProduct.getDescription());

            productRepository.save(product);
            return productRepository.findByIdWithCategoryAndBrand(id);
        }).orElse(null);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}

