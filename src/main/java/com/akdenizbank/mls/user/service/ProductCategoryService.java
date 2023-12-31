package com.akdenizbank.mls.user.service;

import com.akdenizbank.mls.category.ProductCategory;
import com.akdenizbank.mls.user.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory getCategoryById(String id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public ProductCategory createCategory(ProductCategory category) {
        return productCategoryRepository.save(category);
    }

    public ProductCategory updateCategory(String id, ProductCategory updatedCategory) {
        return null;
    }

    public void deleteCategory(String id) {
        productCategoryRepository.deleteById(id);
    }
}
