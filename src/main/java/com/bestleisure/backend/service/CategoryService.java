package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public boolean createCategory(Category category) {
       if(category != null){
           iCategoryRepository.save(category);
           return true;
       }
       else return false;
    }

    @Override
    public Category getOneCategory(Long id) {
        return iCategoryRepository.getOne(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return iCategoryRepository.findCategoryByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        return iCategoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(Long id) {
        if(id<=0){
            return false;
        }
        else {iCategoryRepository.deleteById(id); return true;}
    }

    @Override
    public boolean deleteCategory(String name) {
        if (name != null) {
            iCategoryRepository.deleteCategoryByName(name);
            return true;
        } else
            return false;
    }
}
