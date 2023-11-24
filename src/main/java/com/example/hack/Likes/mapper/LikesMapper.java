package com.example.hack.Likes.mapper;


import com.example.hack.Likes.dto.LikesResponseDto;
import com.example.hack.Likes.dto.LikesRequestDto;
import com.example.hack.Likes.entity.Likes;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LikesMapper {
    LikesResponseDto.Response LikesToLikesResponseDto(Likes likes);

    Likes LikesRequestDtoPostToLikes(LikesRequestDto.Likes likes);
    Likes LikesRequestDtoPatchToLikes(LikesRequestDto.Patch patch);



}
