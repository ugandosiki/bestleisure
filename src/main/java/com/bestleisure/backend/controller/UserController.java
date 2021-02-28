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

    @PostMapping("add")
    public boolean addUser(User user){
        return userService.createUser(user);
    }

    @GetMapping("get")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("get/{id}")
    public User getUser(@PathVariable long id){
        return userService.getOneUser(id);
    }

}
