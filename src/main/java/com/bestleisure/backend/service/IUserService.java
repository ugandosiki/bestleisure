package com.bestleisure.backend.service;


import com.bestleisure.backend.model.User;

import java.util.List;

public interface IUserService {
    boolean createUser(User user);
    User getOneUser(Long id);
    User getUserByName(String name);
    List<User> getAllUsers();
    boolean deleteUser(Long id);
    boolean deleteUser(String name);
}
