package com.example.hack.Post.service;

import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.entity.Post;
import com.example.hack.Post.mapper.PostMapper;
import com.example.hack.Post.repository.PostRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class PostService {
    
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostResponseDto createPost(Post post){
        postRepository.save(post);
        PostResponseDto postResponseDto = postMapper.PostToPostResponseDto(post);
        return postResponseDto;
    }


    public HttpStatus deletePost(int postId){
        postRepository.deleteById(postId);
        return HttpStatus.OK;
    }

//    public HttpStatus patchPost(int postId){
//        postRepository.
//        return HttpStatus.OK;
//    }

    public List<PostResponseDto> getPostBytitle(String title){
        List<Post> postList = postRepository.findByTitleContains(title);
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for (int i=0;i<postList.size();i++){

            postResponseDtoList.add(postMapper.PostToPostResponseDto(postList.get(i)));
        }
        return postResponseDtoList;
    }


    public PostResponseDto getPostById(int postId){
        PostResponseDto postResponseDto = postMapper.PostToPostResponseDto(postRepository.findById(postId));

        return postResponseDto;
    }


    public List<PostResponseDto> getAllPosts() {
        List<Post> postList = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for (int i=0;i<postList.size();i++){

            postResponseDtoList.add(postMapper.PostToPostResponseDto(postList.get(i)));
        }
        return postResponseDtoList;
    }
}
