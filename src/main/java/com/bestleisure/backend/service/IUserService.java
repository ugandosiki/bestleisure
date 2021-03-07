package com.bestleisure.backend.service;


import com.bestleisure.backend.model.User;

import java.util.List;

public interface IUserService {
    void createUser(User user);
    User getOneUser(Long id);
    User getUserByName(String name);
    List<User> getAllUsers();
    void deleteUser(Long id);
    void deleteUser(String name);
}
