package com.bestleisure.backend.repository;


import com.bestleisure.backend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<Type, Long> {
    Type findTypeByName(String name);
    void deleteTypeByName(String name);
}
