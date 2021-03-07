package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Category;

import java.util.List;

public interface ICategoryService {
    void createCategory(Category category);
    Category getOneCategory(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    void deleteCategory(Long id);
    void deleteCategory(String name);
}
