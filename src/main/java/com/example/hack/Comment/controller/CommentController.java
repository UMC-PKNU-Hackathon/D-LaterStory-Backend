package com.example.hack.Comment.controller;

import com.example.hack.Comment.mapper.CommentMapper;
import com.example.hack.Comment.service.CommentService;
import com.umc.mot.comment.dto.CommentRequestDto;
import com.umc.mot.comment.dto.CommentResponseDto;
import com.umc.mot.comment.entity.Comment;
import com.umc.mot.comment.mapper.CommentMapper;
import com.umc.mot.comment.service.CommentService;
import com.umc.mot.packagee.service.PackageService;
import com.umc.mot.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/comment")
@Validated
@AllArgsConstructor
@Log4j2
public class CommentController {
    
    
    private final CommentService commentService;
    private final CommentMapper commentMapper;
//    private final PackageService packageService;

    // Create
    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentRequestDto.Post post,
                                      @Positive @RequestParam int reserveId){
        Comment comment = commentService.createComment(commentMapper.CommentRequestDtoPostToComment(post),reserveId);
        CommentResponseDto.Response response=commentMapper.CommentToCommentResponseDto(comment);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }




    // Read
    @GetMapping("/PurchaseMember")
    public ResponseEntity getComment(){
        commentService
    }


    // Update
    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(@Positive @PathVariable("comment-id") int commentId,
                                     @RequestBody CommentRequestDto.Patch patch) {
        patch.setId(commentId);
        Comment comment = commentService.patchComment(commentMapper.CommentRequestDtoPatchToComment(patch));
        CommentResponseDto.Response response =commentMapper.CommentToCommentResponseDto(comment);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 구매자 - 후기 사진들 업로드 API
    @PatchMapping(value = "/PurchaseMember/upload-images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity patchImagesRoom(CommentRequestDto.PatchImage patchImage) {
        Comment comment = commentService.uploadRoomImage(patchImage.getCommentId(), patchImage.getImages());
        CommentResponseDto.Response response = commentMapper.CommentToCommentResponseDto(comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // Delete
    @DeleteMapping("/PurchaseMember/{comment-id}")
    public ResponseEntity deleteComment(@Positive @PathVariable("comment-id") int commentId) {
        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
