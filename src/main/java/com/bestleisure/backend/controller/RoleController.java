package com.bestleisure.backend.controller;


import com.bestleisure.backend.model.Role;
import com.bestleisure.backend.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public void addRole(Role role) {
         roleService.createRole(role);
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
    public void deleteRole(@PathVariable Long id) {
         roleService.deleteRole(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("delete/{name}")
    public void deleteRole(@PathVariable String name) {
         roleService.deleteRole(name);
    }

}
