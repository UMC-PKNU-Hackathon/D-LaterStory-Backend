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

    default PostResponseDto.ListPost postToList(List<Post> post){
        List<com.example.hack.User.dto.PostResponseDto.Post> post1 = new ArrayList<>();
        for(int i=0;i<post.size();i++){
            com.example.hack.User.dto.PostResponseDto.Post post2 = new com.example.hack.User.dto.PostResponseDto.Post();
            post2.setModifiedAt(post.get(i).getModifiedAt());
            post2.setImage(post.get(i).getImage());
            post2.setUsername(post.get(i).getUser().getUsername());
            post2.setView(post.get(i).getView());
            post2.setTitle(post.get(i).getTitle());
            post2.setContent(post.get(i).getContent());
            post2.setTag(post.get(i).getTag());
            post1.add(post2);
        }

        PostResponseDto.ListPost a = new PostResponseDto.ListPost();
        a.setPostList(post1);
        return a;
    }


}
