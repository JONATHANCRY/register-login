package org.example.registerlogin.service.impl;

import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.repository.Register_Login_Repository;
import org.example.registerlogin.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final Register_Login_Repository registerLoginRepository;

    @Override
    public UserEntity findEmail(String email) {
        return registerLoginRepository.findByEmail(email);
    }
}
