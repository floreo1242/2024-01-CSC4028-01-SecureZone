package com.dongguk.csc40281.securezone.bouquet.dto;

import com.dongguk.csc40281.securezone.bouquet.domain.Flower;
import lombok.Data;

@Data
public class CreateFlowerRequestDto {

    private String name;

    private String color;

    private String language;

    private int price;

    public Flower toEntity() {
        return Flower.builder()
                .name(name)
                .color(color)
                .language(language)
                .price(price)
                .build();
    }

}
