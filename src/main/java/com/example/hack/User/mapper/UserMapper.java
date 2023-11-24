package com.example.hack.User.mapper;



import com.example.hack.Post.entity.Post;
import com.example.hack.User.dto.PostResponseDto;
import com.example.hack.User.dto.UserRequestDto;
import com.example.hack.User.dto.UserResponseDto;
import com.example.hack.User.entity.User;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto.response UserToUserResponseDto(User user);

    User UserRequestDtoPostToUser(UserRequestDto.Post post);
    User UserRequestDtoPatchToUser(UserRequestDto.Patch patch);

    default UserResponseDto.userResponse UserToUserResponseDto(User user, List<Post> post){
        List<PostResponseDto.Post> postList = new ArrayList<>();
        UserResponseDto.userResponse response = new UserResponseDto.userResponse();
        response.setImage(user.getImage());
        response.setUserid(user.getUserid());
        response.setUsername(user.getUsername());
        for(int i=0;i<post.size();i++){
            PostResponseDto.Post post1 = new PostResponseDto.Post();
            post1.setId(post.get(i).getId());
            post1.setTag(post.get(i).getTag());
            post1.setContent(post.get(i).getContent());
            post1.setImage(post.get(i).getImage());
            post1.setUsername(post.get(i).getUser().getUsername());
            post1.setTitle(post.get(i).getTitle());
            post1.setView(post.get(i).getView());
            post1.setCreatedAt(post.get(i).getCreatedAt());
            post1.setModifiedAt(post.get(i).getModifiedAt());
            postList.add(post1);
        }

        response.setPosts(postList);

        return response;
    }


}
