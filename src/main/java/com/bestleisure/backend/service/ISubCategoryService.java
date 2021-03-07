package com.bestleisure.backend.service;

import com.bestleisure.backend.model.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    void createSubCategory(SubCategory subCategory);
    SubCategory getOneSubCategory(Long id);
    SubCategory getSubCategoryByName(String name);
    List<SubCategory> getAllSubCategory();
    void deleteSubCategory(Long id);
    void deleteSubCategory(String name);
}
