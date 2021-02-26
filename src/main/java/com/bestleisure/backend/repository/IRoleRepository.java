package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
    void deleteByName(String name);
}
