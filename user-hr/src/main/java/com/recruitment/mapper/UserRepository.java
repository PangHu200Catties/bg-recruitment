package com.recruitment.mapper;

import com.recruitment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author 贾振乾
 * Date 2019/11/13
 * Time 10:37
 */

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserId(int userId);
}
