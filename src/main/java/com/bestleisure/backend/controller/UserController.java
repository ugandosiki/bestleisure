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

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("add")
    public void addUser(User user) {
         userService.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("get/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getOneUser(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
         userService.deleteUser(id);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @DeleteMapping("delete/{name}")
    public void deleteUserByName(@PathVariable String name) {
         userService.deleteUser(name);
    }
}
