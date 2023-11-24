package com.example.hack.Tag.mapping;

import com.example.hack.Post.entity.Post;
import com.example.hack.Tag.entity.Tag;

import javax.persistence.*;

public class PostTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Post post;
}
