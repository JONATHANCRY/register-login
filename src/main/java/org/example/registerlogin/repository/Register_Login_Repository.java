package org.example.registerlogin.repository;

import org.example.registerlogin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity,Long> {
    // tìm email = email
    // SELECT * FROM register WHERE email = ?; trả về 1 RegisterEntity
    UserEntity findByEmail(String email);
}
