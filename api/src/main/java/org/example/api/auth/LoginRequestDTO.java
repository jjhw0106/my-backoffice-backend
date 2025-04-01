package org.example.api.auth;

import lombok.Getter;

@Getter
public class LoginRequestDTO {
    private String username;
    private String password;
}
