package com.bestleisure.backend.service;



import com.bestleisure.backend.model.Type;

import java.util.List;

public interface ITypeService {
    void createType(Type type);
    Type getOneType(Long id);
    Type getTypeByName(String name);
    List<Type> getAllTypes();
    void deleteType(Long id);
    void deleteType(String name);
}
