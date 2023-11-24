package com.example.hack.Member.service;

import com.example.hack.Member.dto.MemberRequestDto;
import com.example.hack.Member.dto.MemberResponseDto;
import com.example.hack.Member.entity.Member;
import com.example.hack.Member.entity.Member_roles;
import com.example.hack.Member.mapper.MemberMapper;
import com.example.hack.Member.repository.MemberRepository;
import com.example.hack.Member.repository.Member_rolesRepository;
import com.example.hack.Security.JwtTokenProvider;
import com.example.hack.Security.SecurityUtil;
import com.example.hack.Security.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
 
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberMapper memberMapper;
    private final Member_rolesRepository memberRolesRepository;
    private final SecurityUtil securityUtil;
 
    @Transactional
    public TokenInfo login(String memberId, String password) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);
 
        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
 
        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
 
        return tokenInfo;
    }


    public MemberResponseDto.Response signup(MemberRequestDto.Post post){
        Member member = memberMapper.MemberRequestDtoPostToMember(post);
        log.info(member.getMemberId());
        log.info(member.getUsername());

        memberRepository.save(member);
        log.info(member.getMemberId());
        log.info(member.getMemberName());
        log.info("----ASDFASDF--------");
        Member_roles memberRoles = new Member_roles();
        memberRoles.setMemberId(post.getMemberId());
        memberRoles.setRoles("USER");
        log.info(post.getMemberId());
        log.info(post.getMemberName());


        memberRolesRepository.save(memberRoles);
        MemberResponseDto.Response response = memberMapper.MemberToResponseDto(member);

        return response;
    }
}