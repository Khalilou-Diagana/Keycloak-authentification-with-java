package com.khalilou.keycloak.Entities;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
