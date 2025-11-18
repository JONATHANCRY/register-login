package org.example.registerlogin.service.impl;

import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.repository.LoginRepository;
import org.example.registerlogin.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    @Override
    public UserEntity findEmail(String email) {
        return loginRepository.findByEmail(email);
    }
}
