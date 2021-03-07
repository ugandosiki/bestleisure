package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Role;

import java.util.List;


public interface IRoleService{
    void createRole(Role role);
    Role getOneRole(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    void deleteRole(Long id);
    void deleteRole(String name);
    void deleteAllRoles();
}
