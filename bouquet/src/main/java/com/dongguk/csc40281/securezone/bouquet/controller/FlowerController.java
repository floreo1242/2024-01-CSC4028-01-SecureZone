package com.dongguk.csc40281.securezone.bouquet.controller;

import com.dongguk.csc40281.securezone.bouquet.dto.CreateFlowerRequestDto;
import com.dongguk.csc40281.securezone.bouquet.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/flower")
    public ResponseEntity<?> createFlower(@RequestBody CreateFlowerRequestDto createFlowerRequestDto) {
        try {
            flowerService.createFlower(createFlowerRequestDto);
            return ResponseEntity.ok("Successfully created flower");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
