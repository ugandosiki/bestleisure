package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("add")
    public boolean addCategory(Category category) {
        if (category != null) {
            categoryService.createCategory(category);
            return true;
        } else return false;
    }
}
