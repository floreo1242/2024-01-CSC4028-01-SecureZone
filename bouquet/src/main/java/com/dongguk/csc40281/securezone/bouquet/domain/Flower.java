package com.dongguk.csc40281.securezone.bouquet.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flower_id")
    private Long id;

    private String name;

    private String color;

    private String language;

    private int price;

    @OneToMany(mappedBy = "flower")
    private List<Cart> carts = new ArrayList<>();

}
