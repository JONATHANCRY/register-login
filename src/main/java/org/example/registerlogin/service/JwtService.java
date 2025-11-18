package org.example.registerlogin.service;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(RegisterDTO registerDTO);
    String extractEmail(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
