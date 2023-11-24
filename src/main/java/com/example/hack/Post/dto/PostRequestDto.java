package com.example.hack.Post.dto;

import com.example.hack.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class PostRequestDto extends Auditable {

    @Getter
    @Setter
    @AllArgsConstructor
    public class Post {
        private int id;
        private String member;
        private String title;
        private String content;
        private String image;
        private int view;
        private String tag;

        public Post(Post post) {
            this.id = post.getId();
            this.member = post.getMember();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.view = post.getView(); // 조회수
            this.tag = post.getTag(); // 태그
            this.image = post.getImage(); // 이미지
        }


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
