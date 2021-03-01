package com.bestleisure.backend.controller;


import com.bestleisure.backend.model.Role;
import com.bestleisure.backend.service.RoleService;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.enterprise.inject.Produces;
import java.awt.*;
import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public boolean addRole(Role role) {
        return roleService.createRole(role);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("getAll")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getOneRole(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("deleteALl")
    public void deleteAllRoles() {
        roleService.deleteAllRoles();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("delete/{id}")
    public boolean deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("delete/{name}")
    public boolean deleteRole(@PathVariable String name) {
        return roleService.deleteRole(name);
    }

}
