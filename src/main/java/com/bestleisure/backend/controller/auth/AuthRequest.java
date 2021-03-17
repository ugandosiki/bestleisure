package com.bestleisure.backend.controller.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
