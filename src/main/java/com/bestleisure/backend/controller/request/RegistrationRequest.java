package com.bestleisure.backend.controller.request;

import com.bestleisure.backend.model.Role;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegistrationRequest {
    @NotEmpty(message = "The field above must not be empty!")
    @Size(min = 1, max = 200)
    private String name;
    @NotEmpty(message = "The field above must not be empty!")
    @Size(min = 1, max = 200)
    private String email;
    @NotEmpty(message = "The field above must not be empty!")
    @Size(min = 1, max = 200)
    private String password;
    @Size(min = 1, max = 200)
    private String city;
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
