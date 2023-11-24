package com.example.hack.Post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PostRequestDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        private int id;
        private String content;
        private String image;
        private int view;
        private String tag;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private int id;
        private String content;
        private String image;
        private int view;
        private String tag;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class PatchImage {
        private int commentId;
        // 이미지
    }






}
