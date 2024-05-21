package com.dongguk.csc40281.securezone.bouquet.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String name;

    private String phone;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<Cart> carts = new ArrayList<>();

}
