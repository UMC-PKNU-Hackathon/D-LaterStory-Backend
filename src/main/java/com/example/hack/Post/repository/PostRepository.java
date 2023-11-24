package com.example.hack.Post.repository;

import com.example.hack.Post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select b from Post b where b.user.userid=:userId")
    List<Post> findPostByUserId(String userId);


}
