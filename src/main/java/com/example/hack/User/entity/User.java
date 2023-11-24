package com.example.hack.User.entity;


import com.example.hack.Auditable;

import com.example.hack.Post.entity.Post;
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
    @Column
    private String userid;

    @Column
    private String username;

    @Column
    private String image;

    @Column
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> post = new ArrayList<>();


//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Comment> commentList = new ArrayList<>();



}
