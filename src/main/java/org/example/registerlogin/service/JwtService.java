package org.example.registerlogin.service;

import org.example.registerlogin.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserEntity user);
    String extractEmail(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
