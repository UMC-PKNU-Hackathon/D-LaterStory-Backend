package com.example.hack.Comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class CommentRequestDto {

    @Getter
    @AllArgsConstructor
    public static class Comment {
        private int id;
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {
        private int id;
        private String content;
    }


}
