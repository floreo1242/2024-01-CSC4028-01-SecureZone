package com.dongguk.csc40281.securezone.bouquet.dto;

import com.dongguk.csc40281.securezone.bouquet.domain.Cart;
import com.dongguk.csc40281.securezone.bouquet.domain.Flower;
import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartRequestDto {

    private Long flowerId;

    private Integer quantity;

    public Cart toEntity(Member member, Flower flower) {
        return Cart.builder()
                .member(member)
                .flower(flower)
                .quantity(quantity)
                .price(flower.getPrice() * quantity)
                .cartDate(LocalDateTime.now())
                .build();
    }

}
