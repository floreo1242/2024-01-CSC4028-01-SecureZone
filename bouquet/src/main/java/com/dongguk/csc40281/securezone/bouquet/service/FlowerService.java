package com.dongguk.csc40281.securezone.bouquet.service;

import com.dongguk.csc40281.securezone.bouquet.domain.Flower;
import com.dongguk.csc40281.securezone.bouquet.dto.FlowerResponseDto;
import com.dongguk.csc40281.securezone.bouquet.repository.FlowerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FlowerService {

    private final FlowerRepository flowerRepository;

    @Cacheable(value = "todayFlower",key = "T(java.time.LocalDate).now().toString()", unless = "#result == null")
    public FlowerResponseDto todayFlower() {
        LocalDate today = LocalDate.now();
        long seed = today.toEpochDay();
        Random random = new Random(seed);
        Flower flower = flowerRepository.findRandomFLower(random.nextLong())
                .orElseThrow(() -> new IllegalArgumentException("Flower not found"));
        return FlowerResponseDto.builder()
                .id(flower.getId())
                .name(flower.getName())
                .color(flower.getColor())
                .language(flower.getLanguage())
                .price(flower.getPrice())
                .build();
    }

}