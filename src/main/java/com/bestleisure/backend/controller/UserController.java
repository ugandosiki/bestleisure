package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.User;
import com.bestleisure.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public void addUser(User user) {
        userService.createUser(user);
    }

    @GetMapping("getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("get/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getOneUser(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @DeleteMapping("delete/{name}")
    public void deleteUserByName(@PathVariable String name) {
        userService.deleteUser(name);
    }

    //Testing auth
    @GetMapping("admin/get")
    public String getAdmin() {
        return "Hello admin";
    }

    @GetMapping("user/get")
    public String getUser() {
        return "Hello user";

    }
}
