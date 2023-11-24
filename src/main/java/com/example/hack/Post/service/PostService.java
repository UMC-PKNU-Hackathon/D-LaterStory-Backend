package com.example.hack.Post.service;


import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.entity.Post;
import com.example.hack.Post.mapper.PostMapper;
import com.example.hack.Post.repository.PostRepository;
import com.example.hack.User.entity.User;
import com.example.hack.User.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private PostMapper postMapper;

    public PostResponseDto.Response postSave(String userId, PostRequestDto.Post post) {

        Optional<User> user = userRepository.findByUserid(userId);
        User user1 = user.get();
        Post post1 = postMapper.PostRequestDtoPostToPost(post);
        post1.setUser(user1);

        postRepository.save(post1);

        PostResponseDto.Response response = postMapper.PostToCommentResponseDto(post1);

        return response;
    }

    public void deletePost(int postid) {

        Optional<Post> post1 = postRepository.findById(postid);
        Post post2 = post1.get();
        postRepository.delete(post2);

    }

    public PostResponseDto.ListPost getAllPost() {

        List<Post> a = postRepository.findAll();

        PostResponseDto.ListPost response = postMapper.postToList(a);


        return response;
    }


/*
    // 게시글 수정
    @Transactional
    public Integer update(String tag, Integer postId, String title, String content) {
        Post post = postRepository.findById(postId).get();

        if (title != null)
            post.setTitle(title);
        if (tag != null)
            post.setTag(tag);
        if (content != null)
            post.setContent(content);

        return post.getId();
    }

    // 댓글 추가
    @Transactional
    public Integer addComment(String memberId, Integer postId, String content) {
        User user = UserRepository.findById(memberId).get();
        Post post = postRepository.findById(postId).get();

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);
        comment.setUser(user);

        Comment save = commentRepository.save(comment);
        return save.getId();
    }

    // 댓글 제거
    @Transactional
    public void removeComment(Integer commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        comment.setPost(null);

        commentRepository.delete(comment);
    }

     */




}
