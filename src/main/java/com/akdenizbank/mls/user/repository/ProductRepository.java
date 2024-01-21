package com.akdenizbank.mls.user.repository;

import com.akdenizbank.mls.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {

}
