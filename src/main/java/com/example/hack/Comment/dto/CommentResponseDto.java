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
        private String context;
        private String imageUrl;
        private double star;
        private List<String> photos;
        private boolean visible;// true : 보임, false : 안보임

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListResponse {
        private int id;
        private double hotelStar;
        private String context;
        private String imageUrl;
        private double star;
        private List<String> photos;
        private boolean visible;// true : 보임, false : 안보임
        private String HotelName;
        private String RoomName;
        private LocalDateTime modifiedAt;
        private String PackageName;
    }
}