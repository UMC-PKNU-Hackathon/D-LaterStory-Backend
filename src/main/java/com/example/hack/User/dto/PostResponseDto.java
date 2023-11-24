package com.example.hack.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private int id;
        private String content;
        private String title;
        private String image;
        private int view;
        private String username;
        private List<String> tag;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
