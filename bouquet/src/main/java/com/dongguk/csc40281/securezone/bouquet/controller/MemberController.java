package com.dongguk.csc40281.securezone.bouquet.controller;

import com.dongguk.csc40281.securezone.bouquet.dto.CreateMemberRequestDto;
import com.dongguk.csc40281.securezone.bouquet.dto.LoginRequestDto;
import com.dongguk.csc40281.securezone.bouquet.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<?> createMember(@RequestBody CreateMemberRequestDto createMemberRequestDto) {
        try {
            memberService.createMember(createMemberRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created member");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            memberService.login(loginRequestDto);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully logged in");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
