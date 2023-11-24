package com.example.hack.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserResponseDto {

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int id;
        private String userId;
        private String userPw;
        private String name;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse {
        private int id;
        private String userId;
        private String userPw;
        private String name;
    }
}
