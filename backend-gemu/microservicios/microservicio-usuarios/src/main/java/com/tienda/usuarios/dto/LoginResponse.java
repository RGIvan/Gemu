package com.tienda.usuarios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    public LoginResponse(String token) { this.token = token; }
}
