package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Post;
import com.bestleisure.backend.model.SubCategory;

import java.util.List;

public interface ISubCategoryService {
    boolean createSubCategory(SubCategory subCategory);
    SubCategory getOneSubCategory(Long id);
    SubCategory getSubCategoryByName(String name);
    List<SubCategory> getAllSubCategory();
    boolean deleteSubCategory(Long id);
    boolean deleteSubCategory(String name);
}
