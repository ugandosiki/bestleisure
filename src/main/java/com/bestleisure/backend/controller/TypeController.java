package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.Type;
import com.bestleisure.backend.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("types")
public class TypeController {
    final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public boolean addType(Type type) {
        if (type != null) {
            typeService.createType(type);
            return true;
        } else return false;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get")
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }
}
