package com.dongguk.csc40281.securezone.bouquet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {

    private Long id;

    private String username;

    private String name;

    private String phone;

    private String role;

}
