package com.bestleisure.backend.controller;

import com.bestleisure.backend.model.User;
import com.bestleisure.backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
