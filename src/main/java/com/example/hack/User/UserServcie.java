package com.example.hack.User;

import com.example.hack.Post.entity.Post;
import com.example.hack.Post.repository.PostRepository;
import com.example.hack.User.dto.UserRequestDto;
import com.example.hack.User.dto.UserResponseDto;
import com.example.hack.User.entity.User;
import com.example.hack.User.mapper.UserMapper;
import com.example.hack.User.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@AllArgsConstructor
@Slf4j
public class UserServcie {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PostRepository postRepository;

    public User createUser(UserRequestDto.Post user){
        User user1 = userMapper.UserRequestDtoPostToUser(user);


        return userRepository.save(user1);

    }

    public User patchUser(UserRequestDto.Patch patch,String Userid){

        Optional<User> user = userRepository.findByUserid(Userid);
        User user1 = user.get();
        Optional.ofNullable(patch.getUsername()).ifPresent(user1::setUsername);
        Optional.ofNullable(patch.getPassword()).ifPresent(user1::setPassword);

        return userRepository.save(user1);

    }

    public Boolean logincheck(UserRequestDto.login login){

        Optional<User> user = userRepository.findByUserid(login.getUserid());

        if(user.isPresent()){
            return TRUE;
        }else{
            return FALSE;
        }


    }


    public UserResponseDto.userResponse getUser(String Userid){

        Optional<User> user = userRepository.findByUserid(Userid);
        User user1 = user.get();

        List<Post> postList = postRepository.findPostByUserId(Userid);

        log.info(postList.get(0).getContent());

        UserResponseDto.userResponse response = userMapper.UserToUserResponseDto(user1,postList);

        return response;

    }
}
