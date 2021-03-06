package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public boolean addCategory(Category category) {
        if (category != null) {
            categoryService.createCategory(category);
            return true;
        } else return false;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
