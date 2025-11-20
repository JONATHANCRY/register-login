package org.example.registerlogin.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoginDTO {
    private String email;
    private String password;
}
