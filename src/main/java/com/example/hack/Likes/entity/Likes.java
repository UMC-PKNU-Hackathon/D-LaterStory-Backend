package com.example.hack.Likes.entity;


import com.example.hack.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Likes extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
