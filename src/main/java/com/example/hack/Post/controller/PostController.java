package com.example.hack.Post.controller;

import com.example.hack.Comment.mapper.CommentMapper;
import com.example.hack.Comment.service.CommentService;
import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.entity.Post;
import com.example.hack.Post.mapper.PostMapper;
import com.example.hack.Post.repository.PostRepository;
import com.example.hack.Post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post/*")
@Validated
@AllArgsConstructor
@Log4j2
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final PostRepository postRepository;
//    private final PackageService packageService;

    public PostResponseDto createPost(@Valid @RequestBody PostRequestDto.Post post){
        PostResponseDto postResponseDto = postService.createPost(postMapper.PostRequestDtoToPost(post));

        return postResponseDto;
    }

    @DeleteMapping("/delete/{postId}")
    public HttpStatus deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
        return HttpStatus.OK;
    }


    // 제목으로 찾기
    @GetMapping("/{title}")
    public List<PostResponseDto> getPostByTitle(@PathVariable String title){
        List<PostResponseDto> postResponseDtoList = postService.getPostBytitle(title);
        return postResponseDtoList;
    }

    // postId로 찾기
    @GetMapping("/{postId}")
    public PostResponseDto getPostById(@PathVariable int postId){
        PostResponseDto postResponseDto = postService.getPostById(postId);
        return postResponseDto;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){

        return postRepository.findAll();
    }

//    @GetMapping("/posts/{id}")
//    public List<Post> getAllPosts(){
//
//        return postRepository.findAll();
//    }

    // Create
//    @PostMapping
//    public ResponseEntity postComment(@Valid @RequestBody PostRequestDto.Post post,
//                                      @Positive @RequestParam int reserveId){
//        Comment comment = commentService.createComment(commentMapper.CommentRequestDtoPostToComment(post),reserveId);
//        CommentResponseDto.Response response=commentMapper.CommentToCommentResponseDto(comment);
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
}
