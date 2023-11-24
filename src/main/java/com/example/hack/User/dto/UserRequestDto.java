package com.example.hack.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserRequestDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        private String userid;
        private String username;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class login {
        private String userid;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private String username;
        private String password;
    }

}
