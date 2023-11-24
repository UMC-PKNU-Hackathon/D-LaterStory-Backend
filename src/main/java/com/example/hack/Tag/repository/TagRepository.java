package com.example.hack.Tag.repository;

import com.umc.mot.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c where c.purchaseMember.purchaseMemberId=:PurchaseMemberId")
    List<Comment> findCommentByPurchaseMember(int PurchaseMemberId);
}
