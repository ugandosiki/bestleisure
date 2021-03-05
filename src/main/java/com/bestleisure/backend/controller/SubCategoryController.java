package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.SubCategory;
import com.bestleisure.backend.service.SubCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subcategories")
public class SubCategoryController {
    final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public boolean addSubCategory(SubCategory subCategory){
        if (subCategory != null) {
            subCategoryService.createSubCategory(subCategory);
            return true;
        } else return false;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get")
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategory();
    }
}
