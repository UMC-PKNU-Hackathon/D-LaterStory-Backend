package com.example.hack.User.repository;

import com.example.hack.Post.entity.Post;
import com.example.hack.User.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserid(String userId);


}
