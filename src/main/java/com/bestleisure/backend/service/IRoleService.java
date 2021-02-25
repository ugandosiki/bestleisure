package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Role;

import java.util.List;


public interface IRoleService{
    boolean createRole(Role role);
    Role getOneRole(Long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    boolean deleteRole(Long id);
    boolean deleteRole(String name);
}
