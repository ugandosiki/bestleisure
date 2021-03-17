package com.bestleisure.backend.controller.auth;

import com.bestleisure.backend.model.Role;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RegistrationRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private Role role;
}
