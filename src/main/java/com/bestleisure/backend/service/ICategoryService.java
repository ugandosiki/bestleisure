package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.model.User;

import java.util.List;

public interface ICategoryService {
    boolean createCategory(Category category);
    Category getOneCategory(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    boolean deleteCategory(Long id);
    boolean deleteCategory(String name);
}
