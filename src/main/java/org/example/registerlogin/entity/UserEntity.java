package org.example.registerlogin.entity;
// import JPA annotations

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;


@NoArgsConstructor        // constructor rỗng
@AllArgsConstructor       // constructor đầy đủ
@Setter
@Getter
@Entity //đại diện cho một bảng (table) trong cơ sở dữ liệu.
@Table(name = "user") // tên bảng trong database
public class UserEntity {
    @Id // đánh dấu khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự tăng (AUTO_INCREMENT)
    private Long id;

    @Column(name = "last_Name", nullable = false,length = 50) // cột trong bảng
    private String lastName;

    @Column(name = "first_Name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "age",nullable = false)
    private int age;

    @Column(name = "email",nullable = false, length = 100)
    private String email;

    @Column(name = "pass_Word", nullable = false, length = 100)
    private String password;
    // trạng thái xác nhận email
    @Column(name = "verified", nullable = false)
    private boolean verified= false;
    // token xác nhận email
    @Column(name = "verification_token")
    private String verificationToken ;
}

