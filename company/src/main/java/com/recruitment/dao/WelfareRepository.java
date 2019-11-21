package com.recruitment.dao;

import com.recruitment.domain.Welfare;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 17:24
 */
public interface WelfareRepository extends JpaRepository<Welfare,Integer> {
}
