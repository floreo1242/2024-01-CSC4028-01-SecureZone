package com.dongguk.csc40281.securezone.bouquet.dto;

import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import lombok.Data;

@Data
public class CreateMemberRequestDto {

    private String username;

    private String password;

    private String name;

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