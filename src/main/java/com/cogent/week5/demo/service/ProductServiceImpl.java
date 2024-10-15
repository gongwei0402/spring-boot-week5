package com.cogent.week5.demo.service;

import com.cogent.week5.demo.entity.Category;
import com.cogent.week5.demo.entity.Product;
import com.cogent.week5.demo.exception.ApiException;
import com.cogent.week5.demo.exception.ResourceNotFoundException;
import com.cogent.week5.demo.repository.CategoryRepository;
import com.cogent.week5.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public List<Product> getProductByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }


    @Override
    public Product getProductById(Long categoryId, Long productId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categories","categoryId", categoryId));

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("products", "productId", productId));
        if (!product.getId().equals(category.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "product does not belong to category");
        }
        return product;
    }

    @Override
    public Product addProduct(Long categoryId, Product newProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categories","categoryId", categoryId));
        newProduct.setCategory(category);
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long categoryId, Long productId, Product updateProduct) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categories","categoryId", categoryId));

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("products", "productId", productId));
        if (!product.getId().equals(category.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "product does not belong to category");
        }
        product.setName(updateProduct.getName());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long categoryId, Long productId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categories","categoryId", categoryId));

        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("products", "productId", productId));
        if (!product.getId().equals(category.getId())) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "product does not belong to category");
        }
        productRepository.deleteById(productId);

    }
}
