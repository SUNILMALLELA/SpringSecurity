package com.example.Spring.Utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {
    private static final String SECERT = "welcome-to-springboot-security-jwt-secret-key";
    private static final long EXPIRE_TIME =  1000 * 60 * 60;
    private final SecretKey key = Keys.hmacShaKeyFor(SECERT.getBytes());
    public String jwtUtilGenerateToken(String username){
       return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(key)
               .compact();
    }
}
