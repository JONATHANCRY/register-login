package org.example.registerlogin.repository;

import org.example.registerlogin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterLoginRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
    UserEntity findByVerificationToken(String token);
}
