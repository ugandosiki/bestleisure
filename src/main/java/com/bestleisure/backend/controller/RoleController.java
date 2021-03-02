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

    @CrossOrigin(origins = {"crossServer"})
    @PostMapping("add")
    public boolean addRole(Role role) {
        return roleService.createRole(role);
    }

    @CrossOrigin(origins = {"crossServer"})
    @GetMapping("getAll")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @CrossOrigin(origins = {"crossServer"})
    @GetMapping("get/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getOneRole(id);
    }

    @CrossOrigin(origins = {"crossServer"})
    @DeleteMapping("deleteALl")
    public void deleteAllRoles() {
        roleService.deleteAllRoles();
    }

    @CrossOrigin(origins = {"crossServer"})
    @DeleteMapping("delete/{id}")
    public boolean deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @CrossOrigin(origins = {"crossServer"})
    @DeleteMapping("delete/{name}")
    public boolean deleteRole(@PathVariable String name) {
        return roleService.deleteRole(name);
    }

}
