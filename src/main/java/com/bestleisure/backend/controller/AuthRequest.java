package com.bestleisure.backend.controller;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
