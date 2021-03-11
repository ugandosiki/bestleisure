package com.bestleisure.backend.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserTestController {
    @GetMapping("get")
    public String getUser() {
        return "Hello user";
    }
}
