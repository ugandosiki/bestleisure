package com.bestleisure.backend.service;

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
    public boolean createSubCategory(com.bestleisure.backend.model.SubCategory subCategory) {
        if(subCategory != null){
            iSubCategoryRepository.save(subCategory);
            return true;
        }
        else return false;
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
    public boolean deleteSubCategory(Long id) {
        if(id<=0){
            return false;
        }
        else {iSubCategoryRepository.deleteById(id); return true;}
    }

    @Override
    public boolean deleteSubCategory(String name) {
        if (name != null) {
            iSubCategoryRepository.deleteSubCategoryByName(name);
            return true;
        } else
            return false;
    }
}
