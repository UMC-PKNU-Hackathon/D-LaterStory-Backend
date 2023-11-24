package com.example.hack.Post.controller;

import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.entity.Post;
import com.example.hack.Post.service.PostService;
import com.example.hack.User.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/{user-Id}")
    public ResponseEntity savePost(@PathVariable("user-Id") String userId,
                                   @RequestBody PostRequestDto.Post post) {

        PostResponseDto.Response response = postService.postSave(userId, post);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity savePost() {


        PostResponseDto.ListPost response =postService.getAllPost();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{post-Id}")
    public ResponseEntity savePost(@PathVariable("post-Id") int postId){

        postService.deletePost(postId);

        return new ResponseEntity<>(HttpStatus.OK);

    }


}


