package org.example.registerlogin.service.impl;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.mapper.UserMapper;
import org.example.registerlogin.repository.LoginRepository;
import org.example.registerlogin.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;
    private final UserMapper UserMapper;

    @Override
    public RegisterDTO findEmail(String email) {
        UserEntity user = loginRepository.findByEmail(email);
        return UserMapper.toDTO(user);
    }
}
