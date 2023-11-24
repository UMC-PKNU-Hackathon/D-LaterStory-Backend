package com.example.hack.Member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberRequestDto {


    @Getter
    @AllArgsConstructor
    public static class Post {
        private String memberId;
        private String password;
        private String memberName;
    }
}
