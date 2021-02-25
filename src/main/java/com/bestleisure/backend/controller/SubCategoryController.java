package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.SubCategory;
import com.bestleisure.backend.service.SubCategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subcategories")
public class SubCategoryController {
    final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping("add")
    public boolean addSubCategory(SubCategory subCategory){
        if (subCategory != null) {
            subCategoryService.createSubCategory(subCategory);
            return true;
        } else return false;
    }
}
