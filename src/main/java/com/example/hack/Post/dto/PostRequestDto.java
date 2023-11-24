package com.example.hack.Post.dto;

import com.example.hack.Auditable;
import com.example.hack.User.dto.PostResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PostRequestDto{

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        private String title;
        private String content;
        private String image;
        private List<String> tag;
    }





    @Getter
    @Setter
    @AllArgsConstructor
    public static class PatchImage {
        private int commentId;
        // 이미지
    }
}
