package com.akdenizbank.mls.user.controller;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.product.Product;
import com.akdenizbank.mls.user.service.ProductService;
import com.akdenizbank.mls.xaction.ProductXAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public GenericApiResponse getAllProducts(Pageable pageable){
        Page<Product> productPage=productService.getAllProducts(pageable);
        return new GenericApiResponse(200,"Success","123123",productPage);
    }
    @GetMapping("/{id}")
    public GenericApiResponse getProductByID(@PathVariable String id){
        Product productInDB= productService.getProductByID(id);
        if (productInDB == null) {
            throw new RuntimeException("No such Product");
        }
        return new GenericApiResponse(200,"Success","123123",productInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteProduct(@PathVariable String id){
        Product productInDB= productService.getProductByID(id);
        if (productInDB == null) {
            throw new RuntimeException("No such Product");
        }
        productService.deleteProduct(id);
        return new GenericApiResponse(200,"Success","123123",productInDB);
    }
    @PostMapping
    public GenericApiResponse createProduct(@RequestBody ProductXAction xAction){
        Product product= productService.getProductByID(xAction.getId());
        if (product == null) {
            productService.createProduct(xAction);
        }
        return new GenericApiResponse(200,"Success","123123",product);
    }
}