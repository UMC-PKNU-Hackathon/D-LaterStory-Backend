package com.example.hack.User.dto;

import com.example.hack.Post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class UserResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class response {
        private String userid;
        private String username;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class userResponse {
        private String userid;
        private String username;
        private String image;
        private List<PostResponseDto.Post> posts;
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
