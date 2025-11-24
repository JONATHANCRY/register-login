package org.example.registerlogin.service.impl;

import org.example.registerlogin.dto.RegisterDTO;
import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.mapper.UserMapper;
import org.example.registerlogin.repository.RegisterLoginRepository;
import org.example.registerlogin.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final UserMapper UserMapper;
    private final RegisterLoginRepository registerLoginRepository;

    @Override
    public RegisterDTO findEmail(String email) {
        UserEntity user = registerLoginRepository.findByEmail(email);
        RegisterDTO registerDTO = UserMapper.toDTO(user);
        System.out.println(registerDTO);
        return registerDTO;
    }
}
