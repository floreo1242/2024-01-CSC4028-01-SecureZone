package com.dongguk.csc40281.securezone.bouquet.dto;

import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateMemberRequestDto {

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

    @NotBlank(message = "Name is required")
    @Pattern(
            regexp = "^[가-힣a-zA-Z]{2,12}$",
            message = "사용자명은 2~12자의 한글 또는 영문으로만 구성되어야 합니다."
    )
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10,11}$",
            message = "휴대전화번호는 10~11자의 숫자로만 구성되어야 합니다."
    )
    private String phone;

    public Member toEntity(String encodedPassword) {
        return Member.builder()
                .username(username)
                .password(encodedPassword)
                .name(name)
                .phone(phone)
                .build();
    }

}