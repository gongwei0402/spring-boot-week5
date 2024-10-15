package com.cogent.week5.demo.service;

import com.cogent.week5.demo.entity.Category;
import com.cogent.week5.demo.entity.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long categoryId);
    Category addCategory(Category newCategory);
    Category updateCategory(Long categoryId, Category updateCategory);
    void deleteCategory(Long categoryId);
}
