package com.example.hack.Member.repository;

import com.example.hack.Member.entity.Member;
import com.example.hack.Member.entity.Member_roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface Member_rolesRepository extends JpaRepository<Member_roles, String> {

}