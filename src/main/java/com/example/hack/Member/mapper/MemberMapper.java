package com.example.hack.Member.mapper;


import com.example.hack.Member.dto.MemberRequestDto;
import com.example.hack.Member.dto.MemberResponseDto;
import com.example.hack.Member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {


    Member MemberRequestDtoPostToMember(MemberRequestDto.Post post);
    MemberResponseDto.Response MemberToResponseDto(Member member);

}
