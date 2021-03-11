package com.bestleisure.backend.controller;

import com.bestleisure.backend.config.Jwt.JwtProvider;
import com.bestleisure.backend.model.User;
import com.bestleisure.backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(RegistrationRequest registrationRequest) {
        User u = new User();
        u.setName(registrationRequest.getName());
        u.setEmail(registrationRequest.getEmail());
        u.setPassword(registrationRequest.getPassword());
        userService.createUser(u);
        return "Ok";
    }

    @PostMapping("/auth")
    public AuthResponse auth( AuthRequest authRequest) {
        User user = userService.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
