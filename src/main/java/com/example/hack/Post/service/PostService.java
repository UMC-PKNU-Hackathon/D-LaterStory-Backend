package com.example.hack.Post.service;

import com.example.hack.Comment.entity.Comment;
import com.example.hack.Post.entity.Post;
import com.example.hack.Post.repository.CommentRepository;
import com.example.hack.Post.repository.PostRepository;
import com.example.hack.User.entity.User;
import com.example.hack.User.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
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
    private CommentRepository commentRepository;
    private UserRepository userRepository;

    // 게시글 저장
    @Transactional
    public Integer save(String tag, String memberId, String title, String content) {
        User user = userRepository.findById(memberId).get();
        Post post = new Post();

        post.setContent(content);
        post.setTag(tag);
        post.setTitle(title);
        post.set
    }

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



}
