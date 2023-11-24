package com.example.hack.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserRequestDto {

    @Getter
    @AllArgsConstructor
    public static class User {
        private int id;
        private String userId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private int id;
        private String userId;
        private String userPw;
        private String name;
    }

}
