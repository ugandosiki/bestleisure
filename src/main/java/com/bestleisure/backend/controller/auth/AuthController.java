package com.bestleisure.backend.controller.auth;

import com.bestleisure.backend.config.Jwt.JwtProvider;
import com.bestleisure.backend.model.User;
import com.bestleisure.backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegistrationRequest registrationRequest) {
        if (registrationRequest == null) {
            return "Fill all fields!";
        }
        User u = new User();
        u.setName(registrationRequest.getName());
        u.setEmail(registrationRequest.getEmail());
        u.setPassword(registrationRequest.getPassword());
        u.setRole(registrationRequest.getRole());
        userService.createUser(u);
        return "Ok";
    }

    @PostMapping("/auth")
    public AuthResponse auth(AuthRequest authRequest) {
        User user = userService.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
