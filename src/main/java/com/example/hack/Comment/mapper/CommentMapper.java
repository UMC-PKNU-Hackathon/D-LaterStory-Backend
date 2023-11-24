package com.example.hack.Comment.mapper;


import com.example.hack.Comment.dto.CommentResponseDto;
import com.example.hack.Comment.entity.Comment;
import com.example.hack.Comment.dto.CommentRequestDto

import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentResponseDto.Response CommentToCommentResponseDto(Comment comment);

    Comment CommentRequestDtoPostToComment(CommentRequestDto.CommentRequest post);
    Comment CommentRequestDtoPatchToComment(CommentRequestDto.Patch patch);



}
