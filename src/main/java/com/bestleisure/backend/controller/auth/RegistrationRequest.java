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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
