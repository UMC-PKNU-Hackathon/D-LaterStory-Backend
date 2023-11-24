package com.example.hack.Member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberResponseDto {


    @Getter
    @AllArgsConstructor
    public static class Response {
        private String username;
        private String image;
    }
}
