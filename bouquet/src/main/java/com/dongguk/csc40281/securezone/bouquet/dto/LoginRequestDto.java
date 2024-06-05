package com.dongguk.csc40281.securezone.bouquet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequestDto {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{5,12}$")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must be 8 ~ 16 characters long")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,16}$")
    private String password;

}
