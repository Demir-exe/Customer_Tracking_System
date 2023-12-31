package com.akdenizbank.mls.user.repository;

import com.akdenizbank.mls.category.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
}
