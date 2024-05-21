package com.dongguk.csc40281.securezone.bouquet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDto {

    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9]{5,12}$",
            message = "아이디는 5~12자의 영문 대소문자와 숫자로만 구성되어야 합니다."
    )
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must be 8 ~ 16 characters long")
    @Pattern(
            regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,16}$",
            message = "비밀번호는 8~16자의 영문, 숫자, 특수문자를 포함해야 합니다."
    )
    private String password;

}
