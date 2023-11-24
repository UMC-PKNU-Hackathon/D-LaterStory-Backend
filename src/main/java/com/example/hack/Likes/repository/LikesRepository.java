package com.example.hack.Likes.repository;

import com.example.hack.Likes.entity.Likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Integer> {


}
