package com.bestleisure.backend.controller.auth;

import com.bestleisure.backend.config.Jwt.JwtProvider;
import com.bestleisure.backend.controller.request.AuthRequest;
import com.bestleisure.backend.controller.request.RegistrationRequest;
import com.bestleisure.backend.controller.response.AuthResponse;
import com.bestleisure.backend.message.ResponseMessage;
import com.bestleisure.backend.model.User;
import com.bestleisure.backend.repository.IUserRepository;
import com.bestleisure.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final IUserRepository iUserRepository;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, IUserRepository iUserRepository, JwtProvider jwtProvider) {
        this.userService = userService;
        this.iUserRepository = iUserRepository;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid RegistrationRequest registrationRequest) {
        if (iUserRepository.existsUserByEmail(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new ResponseMessage("Email is already taken!"));
        }
        User u = new User();
        u.setName(registrationRequest.getName());
        u.setEmail(registrationRequest.getEmail());
        u.setPassword(registrationRequest.getPassword());
        u.setRole(registrationRequest.getRole());
        userService.createUser(u);
        return ResponseEntity.badRequest().body(new ResponseMessage("You are successfully registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> auth(AuthRequest authRequest) {
        User user = userService.findByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token, user.getId(), user.getName(), user.getEmail(), user.getCity()));
    }
}
