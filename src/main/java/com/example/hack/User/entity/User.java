package com.example.hack.User.entity;


import com.example.hack.Auditable;
import com.example.hack.Comment.entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 로그인 시 입력아이디
    @Column(nullable = false, length = 40)
    private String userId;

    @Column(nullable = false, length = 40)
    private String userPW;

    @Column(nullable = false, length = 40)
    private String name;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Comment> commentList = new ArrayList<>();



}
