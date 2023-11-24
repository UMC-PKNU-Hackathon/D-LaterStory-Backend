package com.example.hack.Post.mapper;


import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.entity.Post;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponseDto.Response PostToCommentResponseDto(Post post);

    Post PostRequestDtoPostToPost(PostRequestDto.Post post);
    Post PostRequestDtoPatchToPost(PostRequestDto.Patch patch);



}
