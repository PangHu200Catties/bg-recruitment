package com.recruitment.dao;

import com.recruitment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/19
 * @Time: 10:27
 * @description:
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByHrId(Integer id);
}
