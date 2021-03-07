package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.repository.ICategoryRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public void createCategory(Category category) {
        try {
            iCategoryRepository.save(category);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception.getMessage());
        }
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
    public void deleteCategory(Long id) {
        try {
            iCategoryRepository.deleteById(id);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Not a valid id" + exception.getMessage());
        }
    }

    @Override
    public void deleteCategory(String name) {
        try {
            iCategoryRepository.deleteCategoryByName(name);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Not a valid name" + exception.getMessage());
        }
    }
}
