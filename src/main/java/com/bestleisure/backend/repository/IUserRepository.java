package com.bestleisure.backend.repository;

import com.bestleisure.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);

    User findUserByEmail(String email);

    void deleteUserByName(String name);
}
