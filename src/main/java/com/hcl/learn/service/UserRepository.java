package com.hcl.learn.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.learn.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
