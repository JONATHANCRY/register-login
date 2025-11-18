package org.example.registerlogin.service;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;

public interface LoginService {
    // lấy email từ db
    RegisterDTO findEmail(String email);
}
