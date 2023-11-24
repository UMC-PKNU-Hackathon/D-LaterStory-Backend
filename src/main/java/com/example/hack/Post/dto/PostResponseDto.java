package com.example.hack.Post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PostResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private int id;
        private String content;
        private String image;
        private int view;
        private String tag;
    }
}
