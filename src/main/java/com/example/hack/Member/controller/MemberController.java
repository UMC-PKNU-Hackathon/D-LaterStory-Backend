package com.example.hack.Member.controller;

import com.example.hack.Member.dto.MemberLoginRequestDto;
import com.example.hack.Member.dto.MemberRequestDto;
import com.example.hack.Member.dto.MemberResponseDto;
import com.example.hack.Member.repository.MemberRepository;
import com.example.hack.Member.service.MemberService;
import com.example.hack.Security.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
 
    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getMemberId();
        String password = memberLoginRequestDto.getPassword();
        TokenInfo tokenInfo = memberService.login(memberId, password);
        return tokenInfo;
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody MemberRequestDto.Post post) {
        MemberResponseDto.Response response = memberService.signup(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}