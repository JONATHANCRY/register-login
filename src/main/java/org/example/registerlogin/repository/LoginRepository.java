package org.example.registerlogin.repository;

import org.example.registerlogin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
}
