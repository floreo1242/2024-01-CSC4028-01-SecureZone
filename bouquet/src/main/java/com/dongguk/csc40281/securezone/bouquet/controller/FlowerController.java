package com.dongguk.csc40281.securezone.bouquet.controller;

import com.dongguk.csc40281.securezone.bouquet.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class FlowerController {

    private final FlowerService flowerService;

    @GetMapping("/flower/today")
    public ResponseEntity<?> todayFlower() {
        try {
            return ResponseEntity.ok(flowerService.todayFlower());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
