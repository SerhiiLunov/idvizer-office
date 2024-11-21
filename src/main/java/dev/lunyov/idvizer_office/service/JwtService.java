package dev.lunyov.idvizer_office.service;

import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;  // Your secret key in Base64 format

    @Value("${jwt.expiration}")
    private long expirationTime;

    private Key signingKey;

    @PostConstruct
    public void init() {
        try {
            // Convert a secret key from Base64
            byte[] keyBytes = Base64.getDecoder().decode(secretKey);
            this.signingKey = new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA512");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Base64 key in 'jwt.secret'. Ensure the key is properly encoded in Base64 format.", e);
        }
    }

    public String generateJwtToken(String email, String phone) {
        try {
            String token = Jwts.builder()
                    .claim("email", email)
                    .claim("phone", phone)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(signingKey, SignatureAlgorithm.HS512)
                    .compact();
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Error generating JWT token", e);
        }
    }

    public String generateJwtToken(String email) {
        try {
            String token = Jwts.builder()
                    .claim("email", email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(signingKey, SignatureAlgorithm.HS512)
                    .compact();
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Error generating JWT token", e);
        }
    }



    public Map<String, Object> parseToken(String token) {
        if (token == null || token.split("\\.").length != 3) {
            throw new IllegalArgumentException("Invalid JWT token format");
        }
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            Map<String, Object> data = new HashMap<>();
            data.put("email", claims.get("email", String.class));
            data.put("phone", claims.get("phone", String.class));
            return data;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JWT token", e);
        }
    }
}