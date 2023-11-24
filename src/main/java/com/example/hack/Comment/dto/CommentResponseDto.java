package com.example.hack.Comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class CommentResponseDto {

    @Getter
    @AllArgsConstructor
    public static class Response {
        private int id;
        private String content;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse {
        private int id;
        private String content;
    }
}