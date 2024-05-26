package com.dongguk.csc40281.securezone.bouquet.service;

import com.dongguk.csc40281.securezone.bouquet.domain.Cart;
import com.dongguk.csc40281.securezone.bouquet.domain.Flower;
import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import com.dongguk.csc40281.securezone.bouquet.dto.CartResponseDto;
import com.dongguk.csc40281.securezone.bouquet.dto.CartRequestDto;
import com.dongguk.csc40281.securezone.bouquet.dto.FlowerResponseDto;
import com.dongguk.csc40281.securezone.bouquet.dto.MemberDto;
import com.dongguk.csc40281.securezone.bouquet.repository.CartRepository;
import com.dongguk.csc40281.securezone.bouquet.repository.FlowerRepository;
import com.dongguk.csc40281.securezone.bouquet.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final FlowerRepository flowerRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createCart(CartRequestDto cartRequestDto, HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("member");
        if (memberDto != null) {
            Member member = memberRepository.findByUsername(memberDto.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
            Flower flower = flowerRepository.findById(cartRequestDto.getFlowerId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 꽃입니다."));
            cartRepository.save(cartRequestDto.toEntity(member, flower));
        }
        else {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }
    }

    public List<CartResponseDto> getCart(HttpSession session) {
        MemberDto memberDto = (MemberDto) session.getAttribute("member");
        if (memberDto != null) {
            Member member = memberRepository.findByUsername(memberDto.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
            List<Cart> cartList = cartRepository.findCartByMember(member);
             return cartList.stream()
                    .map(cart -> CartResponseDto.builder()
                            .id(cart.getId())
                            .flower(FlowerResponseDto.builder()
                                    .id(cart.getFlower().getId())
                                    .name(cart.getFlower().getName())
                                    .color(cart.getFlower().getColor())
                                    .language(cart.getFlower().getLanguage())
                                    .price(cart.getFlower().getPrice())
                                    .build())
                            .quantity(cart.getQuantity())
                            .price(cart.getPrice())
                            .build()
                    )
                    .toList();
        }
        else {
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }
    }

}
