package com.example.hack.Post.mapper;


import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.entity.Post;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post PostRequestDtoToPost(PostRequestDto.Post post);
    PostResponseDto PostToPostResponseDto(Post post);



    Post PostRequestDtoPatchToPost(PostRequestDto.Patch patch);



}
