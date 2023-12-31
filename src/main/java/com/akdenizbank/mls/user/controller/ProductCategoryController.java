package com.akdenizbank.mls.user.controller;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.category.ProductCategory;
import com.akdenizbank.mls.user.service.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public GenericApiResponse getAllCategories() {
        List<ProductCategory> categories = productCategoryService.getAllCategories();
        return new GenericApiResponse(200, "Success", "123123", categories);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getCategoryById(@PathVariable String id) {
        ProductCategory category = productCategoryService.getCategoryById(id);
        if (category == null) {
            throw new RuntimeException("No such category");
        }
        return new GenericApiResponse(200, "Success", "123123", category);
    }

    @PostMapping
    public GenericApiResponse createCategory(@RequestBody ProductCategory category) {
        ProductCategory createdCategory = productCategoryService.createCategory(category);
        return new GenericApiResponse(200, "Success", "123123", createdCategory);
    }

    @PutMapping("/{id}")
    public GenericApiResponse updateCategory(@PathVariable String id, @RequestBody ProductCategory updatedCategory) {
        ProductCategory category = productCategoryService.updateCategory(id, updatedCategory);
        return new GenericApiResponse(200, "Success", "123123", category);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteCategory(@PathVariable String id) {
        productCategoryService.deleteCategory(id);
        return new GenericApiResponse(200, "Success", "123123");
    }
}
