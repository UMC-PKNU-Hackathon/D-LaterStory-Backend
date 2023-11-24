package com.example.hack.Post.controller;

import com.example.hack.Post.dto.PostRequestDto;
import com.example.hack.Post.dto.PostResponseDto;
import com.example.hack.Post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController {

    private final OauthService oauthService;
    private final PostService postService;

    // 전체 페이지 조회
    @GetMapping("all/{page}")
    public List<PostResponseDto> getAllPosts(@PathVariable("page") int page) {

        return postService. getAllPostsInPage(page);
    }

    // 태그(카테고리)별로 모아보기


    // 해당 게시글 보기
    @GetMapping("/view/{id}/{reply}")

    // 게시글 등록
    @PostMapping("{tag}")
    public String savePost(@PathVariable("tag") String  tag,
                           @RequestBody PostRequestDto post,
                           HttpServletRequest request) {
        String userId = oauthSAervice.getUserId(request);
        // 태그, 제목, 내용
        postService.save(tag, userId, post.getTitle(), post.getContent());

        return "OK";
    }

    // 게시글 삭제
    @DeleteMapping("{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postService.delete(id);

        return "Ok";
    }

    // 게시글 수정
    @PostMapping("{tag}/{id}")
    public String updatePost(@PathVariable("id") Integer postId,
                             @PathVariable("tag") String tag,
                             @RequestBody PostRequestDto post) {
        postService.update(tag, postId, post.getTitle(), post.getContent());

        return "OK";
    }

    // 댓글 달기
    @PostMapping("reply/{id}")
    public String addComment(@PathVariable("id") Integer postId,
                             @RequestBody Map<String, String> content,
                             HttpServletRequest request) {
        String userId = oauthService.getUserId(request);
        postService.addComment(userId, postId, content.get("content"));

        return "OK";
    }

    // 댓글 삭제
    @DeleteMapping("reply/{id}")
    public String deleteComment(@PathVariable("id") Integer commentId) {
        postService.removeCommment(commentId);

        return "OK";
    }

}
