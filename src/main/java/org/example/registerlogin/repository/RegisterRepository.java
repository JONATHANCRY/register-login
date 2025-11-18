package org.example.registerlogin.repository;

import org.example.registerlogin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<UserEntity,Long> {
    // kiểm tra giá trị email đã tồn tại chưa, trả về giá trị true, false
    boolean existsByEmail(String email);

    // tìm verification_token = token
    // SELECT * FROM register WHERE verification_token = ?;
    UserEntity findByVerificationToken(String token);

}

//RegisterEntity,Long là tên class(entity) và khoá chính của bảng

//   Tự động có sẵn các method CRUD như:
//    // save(), findAll(), findById(), deleteById(), existsById()

// tự tạo các hàm mới chỉ bằng cách đặt tên theo quy tắc Spring JPA,
// Spring sẽ tự động tạo câu SQL tương ứng.

//Repository trong Spring Data JPA là lớp trung gian giữa ứng dụng và database.
//Nó giúp bạn:
//Không cần tự viết SQL thủ công
//Gọi các hàm có sẵn như save(), findAll(), findById(), deleteById(), v.v.
