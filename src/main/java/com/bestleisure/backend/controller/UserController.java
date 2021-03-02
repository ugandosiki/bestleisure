package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.User;
import com.bestleisure.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin(origins = {"crossServer"})
    @PostMapping("add")
    public boolean addUser(User user) {
        return userService.createUser(user);
    }

    @CrossOrigin(origins = {"crossServer"})
    @GetMapping("getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = {"crossServer"})
    @GetMapping("get/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getOneUser(id);
    }

    @CrossOrigin(origins = {"crossServer"})
    @DeleteMapping("delete/{id}")
    public boolean deleteUserById(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @CrossOrigin(origins = {"crossServer"})
    @DeleteMapping("delete/{name}")
    public boolean deleteUserByName(@PathVariable String name) {
        return userService.deleteUser(name);
    }
}
