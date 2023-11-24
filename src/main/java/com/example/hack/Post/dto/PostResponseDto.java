package com.example.hack.Post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class PostResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private int id;
        private String content;
        private String title;
        private String image;
        private int view;
        private String username;
        private List<String> tag;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListPost {
        private List<com.example.hack.User.dto.PostResponseDto.Post> postList;
    }
}