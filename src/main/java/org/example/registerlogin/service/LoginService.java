package org.example.registerlogin.service;

import org.example.registerlogin.entity.UserEntity;

public interface LoginService {
    // lấy email từ db
    UserEntity findEmail(String email);
}
