package com.bestleisure.backend.repository;


import com.bestleisure.backend.model.SubCategory;
import com.bestleisure.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory findSubCategoryByName(String name);
    void deleteSubCategoryByName(String name);
}
