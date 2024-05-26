package com.dongguk.csc40281.securezone.bouquet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartResponseDto {

    private Long id;

    private FlowerResponseDto flower;

    private int quantity;

    private int price;

}
