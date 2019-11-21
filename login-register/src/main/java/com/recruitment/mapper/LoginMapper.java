package com.recruitment.mapper;

import com.recruitment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/13 15:01
 */
@Component
public interface LoginMapper extends JpaRepository<User,Integer> {
    User findByUserPhone(String userphone);

    User findByNickName(String nickname);
}
