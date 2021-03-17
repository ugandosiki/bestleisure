package com.bestleisure.backend.controller.auth;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class AuthRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
