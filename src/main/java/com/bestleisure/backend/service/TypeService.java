package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Category;
import com.bestleisure.backend.model.Type;
import com.bestleisure.backend.repository.ICategoryRepository;
import com.bestleisure.backend.repository.ITypeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    private final ITypeRepository iTypeRepository;

    public TypeService(ITypeRepository iTypeRepository) {
        this.iTypeRepository = iTypeRepository;
    }

    @Override
    public void createType(Type type) {
        try {
            iTypeRepository.save(type);
        } catch (ObjectNotFoundException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public Type getOneType(Long id) {
        return iTypeRepository.getOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return iTypeRepository.findTypeByName(name);
    }

    @Override
    public List<Type> getAllTypes() {
        return iTypeRepository.findAll();
    }

    @Override
    public void deleteType(Long id) {
        try {
            iTypeRepository.deleteById(id);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Not a valid id" + exception.getMessage());
        }
    }

    @Override
    public void deleteType(String name) {
        try {
            iTypeRepository.deleteTypeByName(name);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Not a valid name" + exception.getMessage());
        }
    }
}
