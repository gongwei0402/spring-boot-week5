package com.cogent.week5.demo.service;

import com.cogent.week5.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductByCategoryId(Long categoryId);

    Product getProductById(Long productId, Long categoryId);
    Product addProduct(Long categoryId, Product newProduct);
    Product updateProduct(Long categoryId, Long ProductId, Product updateProduct);
    void deleteProduct(Long categoryId, Long productId);

}
