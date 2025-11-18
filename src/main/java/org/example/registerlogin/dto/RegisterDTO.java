package org.example.registerlogin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {

    @NotBlank(message = "Họ không được để trống")
    private String lastName;

    @NotBlank(message = "Tên không được để trống")
    private String firstName;

    @Min(value = 1, message = "Tuổi phải lớn hơn 0")
    @Max(value = 120, message = "Tuổi không hợp lệ")
    private int age;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password phải có ít nhất 8 ký tự, gồm chữ hoa, chữ thường, số và ký tự đặc biệt."
    )
    private String password;

    public boolean isVerified() {
        return false;
    }
}

