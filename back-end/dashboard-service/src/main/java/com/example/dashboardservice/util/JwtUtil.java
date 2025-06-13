package com.example.dashboardservice.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    //private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Should match auth-service
    private static final String SECRET = "mysupersecuresecretkey1234567890abcd";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}