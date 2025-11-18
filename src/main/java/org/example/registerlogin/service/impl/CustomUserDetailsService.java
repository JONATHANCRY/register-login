package org.example.registerlogin.service.impl;

import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.repository.LoginRepository;
import org.example.registerlogin.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    // tìm UserDetails từ email nhập vào
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = loginRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserDetails(user) {
        };
    }
}
