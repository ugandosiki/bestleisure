package com.bestleisure.backend.controller.response;

import com.bestleisure.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private Long id;
    private String name;
    private String email;
    private String city;

}
