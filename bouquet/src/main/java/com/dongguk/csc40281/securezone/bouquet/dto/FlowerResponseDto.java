package com.dongguk.csc40281.securezone.bouquet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerResponseDto {

    private Long id;

    private String name;

    private String color;

    private String language;

    private int price;

}
