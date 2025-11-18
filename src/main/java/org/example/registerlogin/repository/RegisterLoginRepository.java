package org.example.registerlogin.repository;

import org.example.registerlogin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterLoginRepository extends JpaRepository<UserEntity,Long> {
    // tìm email = email
    // SELECT * FROM register WHERE email = ?; trả về 1 RegisterEntity
    UserEntity findByEmail(String email);

    // kiểm tra giá trị email đã tồn tại chưa, trả về giá trị true, false
    boolean existsByEmail(String email);

    // tìm verification_token = token
    // SELECT * FROM register WHERE verification_token = ?;
    UserEntity findByVerificationToken(String token);
}
