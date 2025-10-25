package com.tienda.gateway.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;

@Component
public class JwtUtil {

    private final Key SECRET_KEY;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        try {
            this.SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("La clave secreta JWT no es válida", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}