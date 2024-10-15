package com.cogent.week5.demo.controller;

import com.cogent.week5.demo.entity.Product;
import com.cogent.week5.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RequestMapping("/categories")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{CategoryId}/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("categoryId") Long categoryId,
                                                  @PathVariable("productId") Long productId){
        Product product = productService.getProductById(categoryId, productId);
        return  ResponseEntity.ok(product);
    }
    @GetMapping("/{CategoryId}/products")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable("categoryId") Long categoryId){
        List<Product>products = productService.getProductByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }
    @PostMapping("/{CategoryId}/products")
    public ResponseEntity<Product> addProduct(@PathVariable("categoryId") Long categoryId,
                                               @RequestBody Product newProduct){
        Product product = productService.addProduct(categoryId, newProduct);
        return ResponseEntity.ok(product);
    }
    @PutMapping("/{CategoryId}/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("categoryId") Long categoryId,
                                                 @PathVariable("productId") Long productId,
                                                 @RequestBody Product updateProduct){
        Product product = productService.updateProduct(categoryId, productId, updateProduct);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/{CategoryId}/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("categoryId") Long categoryId,
                                              @PathVariable("productId") Long productId){
        productService.deleteProduct(categoryId, productId);
        return null;
    }

}
