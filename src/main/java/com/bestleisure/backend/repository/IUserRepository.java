package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.Role;
import com.bestleisure.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);
    boolean deleteUserByName(String name);
}
