package com.bestleisure.backend.controller;


import com.bestleisure.backend.model.Role;
import com.bestleisure.backend.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("add")
    public boolean addRole(Role role){
       return roleService.createRole(role);
    }
}
