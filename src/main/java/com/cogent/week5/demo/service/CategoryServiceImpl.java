package com.cogent.week5.demo.service;

import com.cogent.week5.demo.entity.Category;
import com.cogent.week5.demo.exception.ResourceNotFoundException;
import com.cogent.week5.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow();
        return category;
    }

    @Override
    public Category addCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(Long categoryId, Category updateCategory) {
        Category category = categoryRepository
                            .findById(categoryId)
                            .orElseThrow(()->new ResourceNotFoundException("categories", "categoryId", categoryId));
        category.setName(updateCategory.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categories", "categoryId", categoryId));
        categoryRepository.delete(category);

    }
}
