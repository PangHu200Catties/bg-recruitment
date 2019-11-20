package com.recruitment.dao;

import com.recruitment.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author 王凯
 * Date 2019/11/19
 * Time 20:56
 */
@Repository
public interface AdminLoginRepository extends JpaRepository<Admin,Integer> {
    Admin findByUsernameAndPassword(String username, String password);
}
