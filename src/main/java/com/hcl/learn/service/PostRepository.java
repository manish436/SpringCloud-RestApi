package com.hcl.learn.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.learn.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
