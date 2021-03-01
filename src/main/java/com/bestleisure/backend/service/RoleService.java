package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Role;
import com.bestleisure.backend.repository.IRoleRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    private final IRoleRepository iRoleRepository;

    public RoleService(IRoleRepository iRoleRepository) {
        this.iRoleRepository = iRoleRepository;
    }

    @Override
    public boolean createRole(Role role) throws ObjectNotFoundException {
        try {
            iRoleRepository.save(role);
            return true;
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Role getOneRole(Long id) {
        return iRoleRepository.getOne(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return iRoleRepository.findRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return iRoleRepository.findAll();
    }

    @Override
    public boolean deleteRole(Long id) throws IllegalArgumentException {
        try {
            iRoleRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRole(String name) throws IllegalArgumentException {
        try {
            iRoleRepository.deleteByName(name);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void deleteAllRoles() {
        iRoleRepository.deleteAll();
    }
}
