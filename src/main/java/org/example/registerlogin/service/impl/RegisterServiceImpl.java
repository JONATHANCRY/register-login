package org.example.registerlogin.service.impl;

import org.example.registerlogin.entity.UserEntity;
import org.example.registerlogin.repository.Register_Login_Repository;
import org.example.registerlogin.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final Register_Login_Repository registerLoginRepository;
//    private final EmailServiceImpl emailService;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity save(UserEntity user) {
        // mã hoá password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        // truyền password mới vào
        user.setPassword(hashedPassword);
        // tạo token cho register
        String token = UUID.randomUUID().toString();
        // set giá trị VerificationToken = token
        user.setVerificationToken(token);
        // set giá trị verified = false
        user.setVerified(false);
        // gởi email xác nhận đến register.getEmail() và token
//        emailService.sendVerificationEmail(user.getEmail(),token);
        return registerLoginRepository.save(user);
    }
// kiểm tra email đã tồn tại chưa trả về true, false
    @Override
    public boolean emailExists(String email){
        // kiểm tra email người dùng nhập vào đã có trong db chưa rồi mới lưu
        // 1) lấy được giá trị email người dùng nhập x
        // 2) kiểm tra với dữ kiệu trong db
        // 3) nếu có rồi thì in ra màng hình lỗi
        // 4) nếu chưa có thì lưu xún db
        return registerLoginRepository.existsByEmail(email);
    }


    @Override
    public boolean verifyAccount(String token) {
        // tìm user có VerificationToken = token
        UserEntity user = registerLoginRepository.findByVerificationToken(token);
        // nếu có user thì setVerified true và xoá token
        if (user != null) {
            user.setVerified(true);
            user.setVerificationToken(null); // xoá token sau khi xác nhận
            // lưu user đã cập nhật vào db
            registerLoginRepository.save(user);
            return true;
        }
        return false;
    }
}


