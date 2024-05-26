package com.dongguk.csc40281.securezone.bouquet.service;

import com.dongguk.csc40281.securezone.bouquet.domain.Flower;
import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import com.dongguk.csc40281.securezone.bouquet.dto.CartRequestDto;
import com.dongguk.csc40281.securezone.bouquet.repository.CartRepository;
import com.dongguk.csc40281.securezone.bouquet.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final FlowerRepository flowerRepository;

    @Transactional
    public void createCart(CartRequestDto cartRequestDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            Member member = (Member) auth.getPrincipal();
            Flower flower = flowerRepository.findById(cartRequestDto.getFlowerId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 꽃입니다."));
            cartRepository.save(cartRequestDto.toEntity(member, flower));
        }
        else {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }
    }

}
