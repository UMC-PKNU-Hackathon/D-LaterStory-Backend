package com.example.hack.Tag.entity;


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
public class Tag extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 로그인 시 입력아이디
    @Column(nullable = false, length = 40)
    private String tagName;


}
