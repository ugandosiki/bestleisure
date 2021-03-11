package com.bestleisure.backend.controller;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class AuthRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
