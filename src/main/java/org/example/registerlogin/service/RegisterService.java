package org.example.registerlogin.service;
import org.example.registerlogin.entity.UserEntity;

public interface RegisterService {
    // interface lưu dữ liệu vào db
    UserEntity save(UserEntity register);

    // kiểm tra email đã tồn tại chưa trả về true, false
    boolean emailExists(String email);

    boolean verifyAccount(String token);
}
