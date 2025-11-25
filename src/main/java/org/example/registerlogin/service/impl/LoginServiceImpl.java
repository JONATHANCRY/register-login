package org.example.registerlogin.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.mapper.UserMapper;
import org.example.registerlogin.repository.RegisterLoginRepository;
import org.example.registerlogin.service.LoginService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final UserMapper userMapper;
    private final RegisterLoginRepository registerLoginRepository;

    @Override
    public RegisterDTO findEmail(String email) {
        UserEntity user = registerLoginRepository.findByEmail(email);
        RegisterDTO registerDTO = userMapper.toDto(user);
        System.out.println(registerDTO);
        return registerDTO;
    }
}
