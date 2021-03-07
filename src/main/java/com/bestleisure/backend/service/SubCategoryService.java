package com.bestleisure.backend.service;

import com.bestleisure.backend.model.SubCategory;
import com.bestleisure.backend.repository.ISubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService implements ISubCategoryService {
    final ISubCategoryRepository iSubCategoryRepository;

    public SubCategoryService(ISubCategoryRepository iSubCategoryRepository) {
        this.iSubCategoryRepository = iSubCategoryRepository;
    }

    @Override
    public void createSubCategory(SubCategory subCategory) {
        iSubCategoryRepository.save(subCategory);
    }

    @Override
    public com.bestleisure.backend.model.SubCategory getOneSubCategory(Long id) {
        return iSubCategoryRepository.getOne(id);
    }

    @Override
    public com.bestleisure.backend.model.SubCategory getSubCategoryByName(String name) {
        return iSubCategoryRepository.findSubCategoryByName(name);
    }

    @Override
    public List<com.bestleisure.backend.model.SubCategory> getAllSubCategory() {
        return iSubCategoryRepository.findAll();
    }

    @Override
    public void deleteSubCategory(Long id) {
        iSubCategoryRepository.deleteById(id);
    }

    @Override
    public void deleteSubCategory(String name) {
        iSubCategoryRepository.deleteSubCategoryByName(name);
    }
}
