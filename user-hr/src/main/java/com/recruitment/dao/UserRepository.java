package com.recruitment.dao;

import com.recruitment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * Author 王凯
 * Date 2019/11/14
 * Time 10:18
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}

