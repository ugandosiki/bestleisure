package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
    boolean deleteCategoryByName(String name);
}
