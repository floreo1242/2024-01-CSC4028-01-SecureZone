package com.dongguk.csc40281.securezone.bouquet.service;

import com.dongguk.csc40281.securezone.bouquet.domain.Member;
import com.dongguk.csc40281.securezone.bouquet.dto.CreateMemberRequestDto;
import com.dongguk.csc40281.securezone.bouquet.dto.LoginRequestDto;
import com.dongguk.csc40281.securezone.bouquet.dto.MemberDto;
import com.dongguk.csc40281.securezone.bouquet.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.LoginException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Transactional
    public void createMember(CreateMemberRequestDto createMemberRequestDto) {
        isDuplicated(createMemberRequestDto.getUsername());
        memberRepository.save(createMemberRequestDto.toEntity(passwordEncoder.encode(createMemberRequestDto.getPassword())));
    }

    public MemberDto login(LoginRequestDto loginRequestDto) throws LoginException {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getUsername(),
                    loginRequestDto.getPassword()
            );
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Member member = memberRepository.findByUsername(loginRequestDto.getUsername())
                    .orElseThrow(() -> new LoginException("Invalid username or password"));
            return MemberDto.builder()
                    .id(member.getId())
                    .username(member.getUsername())
                    .name(member.getName())
                    .name(member.getName())
                    .phone(member.getPhone())
                    .role(member.getRole())
                    .build();
        } catch (AuthenticationException e) {
            throw new LoginException("Invalid username or password");
        }
    }

    public void checkDuplicate(String username) {
        isDuplicated(username);
    }

    private void isDuplicated(String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
