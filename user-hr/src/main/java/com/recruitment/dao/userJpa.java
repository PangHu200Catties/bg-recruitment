package com.recruitment.dao;

import com.recruitment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 李江涛
 */
public interface userJpa extends JpaRepository<User,Integer> {

}
