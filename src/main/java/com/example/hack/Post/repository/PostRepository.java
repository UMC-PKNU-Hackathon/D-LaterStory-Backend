package com.example.hack.Post.repository;

import com.example.hack.Post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

//    public interface MemberRepository extends JpaRepository<Member, Long> {
//        Optional<Member> findByMemberId(String username);
//
//        @Modifying
//        @Transactional
//        @Query("INSERT INTO Member (Member_memberId, roles) VALUES (:memberId, :roles)")
//        void insertMemberRoles(@Param("memberId") String memberId, @Param("roles") String roles);
//
//
//    }


    List<Post> findByTitleContains(String title);
}
