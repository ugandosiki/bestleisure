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
    public void createRole(Role role) throws ObjectNotFoundException {
        try {
            iRoleRepository.save(role);
        } catch (ObjectNotFoundException e) {
            throw new RuntimeException(e.getMessage());
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
    public void deleteRole(Long id) throws IllegalArgumentException {
        try {
            iRoleRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteRole(String name) throws IllegalArgumentException {
        try {
            iRoleRepository.deleteByName(name);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteAllRoles() {
        iRoleRepository.deleteAll();
    }
}
