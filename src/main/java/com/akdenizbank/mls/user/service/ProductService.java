package com.akdenizbank.mls.user.service;
import com.akdenizbank.mls.product.Product;
import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.user.repository.ProductRepository;
import com.akdenizbank.mls.xaction.ProductXAction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public Product createProduct(ProductXAction xAction){
        Product product= new Product();
        product.setName(xAction.getName());
        product.setId(xAction.getId());
        product.setPrice(xAction.getPrice());
        product.setCategory(xAction.getCategory());
        return this.productRepository.save(product);
    }

    public Product getProductByID(String id){
        return this.productRepository.findById(id).orElse(null);
    }
    public Page<Product> getAllProducts(Pageable pageable){
        return this.productRepository.findAll(pageable);
    }

    public void deleteProduct(String id){
        Product ProductInDB=getProductByID(id);
        if ( ProductInDB == null) {
            throw new RuntimeException("No Such Product");
        }
        productRepository.delete(ProductInDB);
    }
}
